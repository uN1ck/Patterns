package actionObject.actions;

import actionObject.ActionObject;

public class SpecialActionCreateAssultUnit extends SpecialAction {

    private static String[] requiredProperties = {"SupplyMaximal", "SupplyCurrent"};

    @Override
    public void doAction(ActionObject target, ActionObject owner) {

    }

    @Override
    public String[] requiredProperties() {
        return new String[0];
    }

}
