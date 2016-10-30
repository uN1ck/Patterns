package actionObject.actions;

import actionObject.ActionObject;

/**
 * Класс действия передачи ресурсов. описывает весь процесс передачи ресурсов от одного объектаДействия к другому.
 * Свойства связанные с классом и требуемые при добавлении действия к объектуДействия:
 * (MaximalSupply, CurrentSupply)
 */

public class SpecialActionGetSupplies extends SpecialAction {
    private static String[] requiredProperties = {"SupplyMaximal", "SupplyCurrent"};
    private String name = "SuppliesTransfer";
    private int singleTransmission;

    /**
     * Конструктор действия оп передаче ресурсов от {@param target} к {@param owner}
     * с заданной величиной разовой передачи
     *
     * @param singleTransmission величина разовой передачи
     */
    public SpecialActionGetSupplies(int singleTransmission) {
        this.singleTransmission = singleTransmission;
    }

    /**
     * Метод передачи ресурсов от {@param target} к {@param owner}
     *
     * @param target Объект над которым выполняется действие
     * @param owner  Объект выполняющий действие
     */
    @Override
    public void doAction(ActionObject target, ActionObject owner) {
        owner.getProperty("CurrentSupply");
    }

    @Override
    public String[] requiredProperties() {
        return requiredProperties;
    }

}

