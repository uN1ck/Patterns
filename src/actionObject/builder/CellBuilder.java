package actionObject.builder;

import actionObject.actions.SpecialAction;
import actionObject.actions.SpecialActionsDoUnitAction;
import util.world.Cell;

import java.util.ArrayList;

public class CellBuilder extends ActionObjectBuilder {

    private ArrayList<SpecialAction> actionTemplateList = new ArrayList<>();

    @Override
    public Cell buildActionObject() {
        Cell currentObject = new Cell();

        currentObject.addSpecialAction(new SpecialActionsDoUnitAction(currentObject));

        for (SpecialAction currentAction : actionTemplateList) {
            currentObject.addSpecialAction(currentAction);
        }

        return currentObject;
    }

    @Override
    public ActionObjectBuilder clone() {
        CellBuilder clone = new CellBuilder();
        clone.actionTemplateList = new ArrayList<>(actionTemplateList);
        return clone;
    }

}
