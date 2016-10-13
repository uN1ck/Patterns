package actionObject.actions;

import actionObject.ActionObject;

/**
 * Класс создания логистического юнита
 */
public class SpecialActionCreateSupplyUnit implements SpecialAction {
    private String name = "CreateSupplyUnit";
    private int cost = 10;

    @Override
    public void doAction(ActionObject target, ActionObject owner) {

    }

    @Override
    public String actionName() {
        return name;
    }

    @Override
    public String[] requiredProperties() {
        return new String[0];
    }

}
