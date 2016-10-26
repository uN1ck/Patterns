package actionObject;

import actionObject.actions.SpecialAction;
import util.Aggregation.ConcreteAggregator;
import util.Aggregation.Iterator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionObject implements Comparable {
    private ConcreteAggregator<SpecialAction> specialActions = new ConcreteAggregator<>();
    //private ArrayList<SpecialAction> specialActions = new ArrayList<>();
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
        this.specialActions.getNormalArray().add(specialAction);
    }

    public void deleteSpecialAction(SpecialAction specialAction) {
        this.specialActions.getNormalArray().remove(specialAction);
    }

    public List<SpecialAction> getSpecialActions() {
        return specialActions.getNormalArray();
    }

    public SpecialAction getSpecialActionByName(String name) {
        SpecialAction result = null;
        Iterator<SpecialAction> itr = specialActions.createIterator();

        SpecialAction current = itr.next();
        while (current != null) {
            if (current.actionName() == name)
                result = current;
            current = itr.next();
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
    public int compareTo(Object o) {
        return this.hashCode() - o.hashCode();
    }
}

