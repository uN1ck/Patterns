package actionObject;

import actionObject.actions.SpecialAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionObject implements Comparable {
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

    @Override
    public String toString() {
        String res = "Properties: \n";
        for (Map.Entry current : properties.entrySet())
            res += "[ name: " + current.getKey() + " value: " + current.getValue() + " ]\n";
        res += "Actions:\n[";
        for (SpecialAction current : specialActions)
            res += current.actionName() + " ";
        res += "]\n";
        return res + super.toString();
    }

    @Override
    public int compareTo(Object o) {
        return this.hashCode() - o.hashCode();
    }
}

