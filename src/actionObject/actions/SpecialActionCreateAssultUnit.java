package actionObject.actions;

import actionObject.ActionObject;

public class SpecialActionCreateAssultUnit implements SpecialAction {
    private String name = "CreateAssaultUnit";
    private static String[] requiredProperties = {"SupplyMaximal", "SupplyCurrent"};
    private int createingCost = 10;


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
