package actionObject.Builder;

import actionObject.ActionObject;
import actionObject.actions.SpecialAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Строитель юнитов
 */
public class UnitBuilder extends ActionObjectBuilder {


    @Override
    public ActionObject buildActionObject() {
        ActionObject currentObject = new ActionObject();

        currentObject.addProperty("HealthMaximal", "10");
        currentObject.addProperty("Health", "10");

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
        UnitBuilder clone = new UnitBuilder();
        clone.actionTemplateList = new ArrayList<>(actionTemplateList);
        clone.propertiesTemplateList = new HashMap<>(propertiesTemplateList);
        clone.actionToPropertyList = new HashMap<>(actionToPropertyList);
        return clone;
    }


}
