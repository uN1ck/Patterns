package actionObject.actions;

import actionObject.ActionObject;

/**
 * Класс действия передачи ресурсов. описывает весь процесс передачи ресурсов от одного объектаДействия к другому.
 * Свойства связанные с классом и требуемые при добавлении действия к объектуДействия:
 * (MaximalSupply, CurrentSupply)
 */

public class SpecialActionCarrySupplies extends SpecialAction {

    private int capacity;
    private int value;

    public SpecialActionCarrySupplies(int capacity, int value) {
        this.capacity = capacity;
        this.value = value;
    }

    /**
     * Метод передачи ресурсов от {@param target} к {@param owner}
     *
     * @param target Объект над которым выполняется действие
     * @param owner  Объект выполняющий действие
     */
    @Override
    public void doAction(ActionObject target, ActionObject owner) {
        SpecialActionTransferSupply targetTransfer = (SpecialActionTransferSupply) target.getSpecialActionByName(SpecialActionTransferSupply.class.getSimpleName());
        SpecialActionCarrySupplies targetSupplies = (SpecialActionCarrySupplies) target.getSpecialActionByName(SpecialActionCarrySupplies.class.getSimpleName());

        int transfer = targetTransfer.getSingleTransmission();
        if (this.value > transfer) {
            this.value -= transfer;
        } else {
            transfer = this.value;
            this.value = 0;
        }
        int overflow = targetSupplies.appendSupplies(transfer);
        this.value += overflow;
    }

    public int appendSupplies(int value) {
        this.value += value;
        int overflow = 0;
        if (this.value > this.capacity) {
            overflow = this.value - this.capacity;
            this.value = this.capacity;
        }
        return overflow;
    }

}

