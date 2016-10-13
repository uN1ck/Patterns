package actionObject.UnitFactory;

import actionObject.ActionObject;
import actionObject.actions.SpecialAction;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConcreteUnitFactory implements BasicActionObjectFactory {

    private ArrayList<SpecialAction> actionTemplateList = new ArrayList<>();
    private Map<String, String> propertiesTemplateList = new HashMap<>();
    private Map<String, ArrayList<String>> actionToPropertyList = new HashMap<>();

    @Override
    public ActionObject buildActionObject() {
        ActionObject currentObject = new ActionObject();

        for (Map.Entry<String, String> currentProperty : propertiesTemplateList.entrySet()) {
            currentObject.addProperty(currentProperty.getKey(), currentProperty.getValue());
        }
        for (SpecialAction currentAction : actionTemplateList) {
            currentObject.addSpecialAction(currentAction);
        }

        return currentObject;
    }

    @Override
    public void addAction(SpecialAction action, Map<String, String> properties) {

        for (String current : action.requiredProperties())
            if (!(properties.containsKey(current)))
                properties.put(current, "#none");

        actionTemplateList.add(action);
        propertiesTemplateList.putAll(properties);

        actionToPropertyList.put(action.actionName(), new ArrayList<>());
        for (Map.Entry<String, String> currentProperty : properties.entrySet()) {
            actionToPropertyList.get(action.actionName()).add(currentProperty.getKey());
        }
    }

    @Override
    public void setProperty(String name, String value) {
        propertiesTemplateList.put(name, value);
    }

    @Override
    public String getProperty(String name) {
        return propertiesTemplateList.get(name);
    }

    @Override
    public BasicActionObjectFactory clone() {
        ConcreteUnitFactory clone = new ConcreteUnitFactory();
        clone.actionTemplateList = new ArrayList<>(actionTemplateList);
        clone.propertiesTemplateList = new HashMap<>(propertiesTemplateList);
        clone.actionToPropertyList = new HashMap<>(actionToPropertyList);
        return clone;
    }

    @Override
    public ArrayList<SpecialAction> getActions() {
        return actionTemplateList;
    }

}
