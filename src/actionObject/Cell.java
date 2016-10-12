package actionObject;

import actionObject.actions.SpecialActionGetSupplies;
import actionObject.actions.SpecialActionGiveSupplies;
import actionObject.parts.SpecialPartTank;

public class Cell extends ActionObject {
    private ActionObject unit;

    public Cell() {
        super();
        //super.addSpecialPart(new SpecialPartTank(100));
        addSpecialAction(new SpecialActionGiveSupplies());
        addSpecialAction(new SpecialActionGetSupplies());
        addSpecialPart(new SpecialPartTank(100));
    }

    public void setSupply(int value) {
        getSpecialActionByName("GetSupplies").doAction(this, this);
    }

    public boolean tryPlaceUnit(ActionObject value) {
        if (unit == null) {
            unit = value;
            return true;
        }
        return false;
    }

    public ActionObject tryGetUnit() {
        return unit;
    }
}