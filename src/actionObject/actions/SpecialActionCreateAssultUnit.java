package actionObject.actions;

import actionObject.ActionObject;

public class SpecialActionCreateAssultUnit implements SpecialAction {
    private String name = "CreateAssaultUnit";
    private int cost = 10;

    @Override
    public void doAction(ActionObject target, ActionObject owner) {

    }

    @Override
    public String actionName() {
        return name;
    }

}
