package actionObject.builder;

import actionObject.ActionObject;
import actionObject.actions.SpecialAction;

import java.util.ArrayList;

/**
 * Строитель юнитов
 */
public class UnitBuilder extends ActionObjectBuilder {


    @Override
    public ActionObject buildActionObject() {
        ActionObject currentObject = new ActionObject();

        for (SpecialAction currentAction : actionTemplateList) {
            currentObject.addSpecialAction(currentAction);
        }

        return currentObject;
    }

    @Override
    public ActionObjectBuilder clone() {
        UnitBuilder clone = new UnitBuilder();
        clone.actionTemplateList = new ArrayList<>(actionTemplateList);
        return clone;
    }


}
