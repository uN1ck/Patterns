package actionObject;

import actionObject.actions.SpecialActionGetSupplies;
import actionObject.actions.SpecialActionGiveSupplies;
import actionObject.parts.SpecialPartBase;
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

    public Cell(int supply, int terrain) {
        super();
        //super.addSpecialPart(new SpecialPartTank(100));
        addSpecialAction(new SpecialActionGiveSupplies());
        addSpecialAction(new SpecialActionGetSupplies());
        addSpecialPart(new SpecialPartTank(supply));
        if (terrain == 1) {
            unit = new ActionObject();
            unit.addSpecialPart(new SpecialPartBase(50));
        }
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