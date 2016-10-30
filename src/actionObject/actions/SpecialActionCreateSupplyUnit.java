package actionObject.actions;

import actionObject.ActionObject;

/**
 * Класс создания логистического юнита
 */
public class SpecialActionCreateSupplyUnit extends SpecialAction {

    @Override
    public void doAction(ActionObject target, ActionObject owner) {

    }

    @Override
    public String[] requiredProperties() {
        return new String[0];
    }

}
