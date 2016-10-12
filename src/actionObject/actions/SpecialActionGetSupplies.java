package actionObject.actions;

import actionObject.ActionObject;
import actionObject.parts.SpecialPart;

public class SpecialActionGetSupplies implements SpecialAction {
    private String name = "GetSupplies";

    @Override
    public void doAction(ActionObject target, ActionObject owner) {
        SpecialPart tank = owner.getSpecialPartByName("PartTank");

    }

    @Override
    public String actionName() {
        return name;
    }

}
