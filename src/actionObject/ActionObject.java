package actionObject;

import actionObject.actions.SpecialAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionObject {
    private ArrayList<SpecialAction> specialActions = new ArrayList<>();
    private Map<String, String> properties = new HashMap<>();

    public ActionObject() {
        properties.put("owner", "none");
        properties.put("name", "#unnamed");
    }

    public ActionObject(String name) {
        properties.put("owner", "none");
        properties.put("name", name);
    }

    //

    public void addSpecialAction(SpecialAction specialAction) {
        this.specialActions.add(specialAction);
    }

    public void deleteSpecialAction(SpecialAction specialAction) {
        this.specialActions.remove(specialAction);
    }

    public List<SpecialAction> getSpecialActions() {
        return specialActions;
    }

    public SpecialAction getSpecialActionByName(String name) {
        SpecialAction result = null;
        for (SpecialAction current : specialActions) {
            if (current.actionName() == name)
                result = current;
        }
        return result;
    }

    public void addProperty(String name, String value) {
        properties.put(name, value);
    }

    public String getProperty(String name) {
        return properties.get(name);
    }

}

