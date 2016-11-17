package actionObject.actions;

import actionObject.ActionObject;

public class SpecialActionTransferSupply extends SpecialAction {
    private int singleTransmission;

    public SpecialActionTransferSupply(int singleTransmission) {
        this.singleTransmission = singleTransmission;
    }

    /**
     * Метод активного специального действия юнита
     *
     * @param target Объект над которым выполняется действие
     * @param owner  Объект выполняющий действие
     */
    @Override
    public void doAction(ActionObject target, ActionObject owner) {
        SpecialActionCarrySupplies ownerSupplies = (SpecialActionCarrySupplies) owner.getSpecialActionByName(SpecialActionCarrySupplies.class.getSimpleName());
        SpecialActionCarrySupplies targetSupplies = (SpecialActionCarrySupplies) target.getSpecialActionByName(SpecialActionCarrySupplies.class.getSimpleName());

        targetSupplies.doAction(owner, target);
    }

    public int getSingleTransmission() {
        return singleTransmission;
    }
}
