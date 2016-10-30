package actionObject.actions;

import actionObject.ActionObject;
import util.world.Cell;

public class SpecialActionsDoUnitAction extends SpecialAction {
    Cell cell;

    public SpecialActionsDoUnitAction(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void doAction(ActionObject target, ActionObject owner) throws Exception {
        if (!cell.isEmpty())
            cell.getUnit().doActions();
    }

    @Override
    public String[] requiredProperties() {
        return new String[0];
    }
}
