package actionObject.actions;

import actionObject.ActionObject;

public class SpecialActionGiveSupplies implements SpecialAction {
    private String name = "GiveSupplies";

    @Override
    public void doAction(ActionObject target, ActionObject owner) {

    }

    @Override
    public String actionName() {
        return name;
    }

}

