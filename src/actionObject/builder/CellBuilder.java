package actionObject.builder;

import actionObject.actions.SpecialAction;
import actionObject.actions.SpecialActionsDoUnitAction;
import util.world.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CellBuilder extends ActionObjectBuilder {

    private ArrayList<SpecialAction> actionTemplateList = new ArrayList<>();
    private Map<String, String> propertiesTemplateList = new HashMap<>();
    private Map<String, ArrayList<String>> actionToPropertyList = new HashMap<>();

    @Override
    public Cell buildActionObject() {
        Cell currentObject = new Cell();

        currentObject.addProperty("name", "cell");
        currentObject.addProperty("owner", "world");

        currentObject.addSpecialAction(new SpecialActionsDoUnitAction(currentObject));

        for (Map.Entry<String, String> currentProperty : propertiesTemplateList.entrySet()) {
            currentObject.addProperty(currentProperty.getKey(), currentProperty.getValue());
        }
        for (SpecialAction currentAction : actionTemplateList) {
            currentObject.addSpecialAction(currentAction);
        }

        return currentObject;
    }

    @Override
    public ActionObjectBuilder clone() {
        CellBuilder clone = new CellBuilder();
        clone.actionTemplateList = new ArrayList<>(actionTemplateList);
        clone.propertiesTemplateList = new HashMap<>(propertiesTemplateList);
        clone.actionToPropertyList = new HashMap<>(actionToPropertyList);
        return clone;
    }

}
