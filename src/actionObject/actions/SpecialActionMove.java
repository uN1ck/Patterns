package actionObject.actions;

import actionObject.ActionObject;

public class SpecialActionMove implements SpecialAction {
    private String name = "Move";
    @Override
    public void doAction(ActionObject target, ActionObject owner) {

    }

    @Override
    public String actionName() {
        return name;
    }

}
