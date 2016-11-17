package actionObject.actions;

import actionObject.ActionObject;
import util.world.Cell;

/**
 * Класс действия содержимого клетки. Отвечет за выполение всех действий вложенного юнита
 */
public class SpecialActionsDoUnitAction extends SpecialAction {
    Cell cell;

    public SpecialActionsDoUnitAction(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void doAction(ActionObject target, ActionObject owner) {
        if (!cell.isEmpty())
            cell.getUnit().doActions();
    }

}
