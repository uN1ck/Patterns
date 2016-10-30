package actionObject;

import actionObject.actions.SpecialAction;
import behaviour.Behaviour;
import behaviour.NullBehaviour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionObject implements Comparable {
    Behaviour driver;
    private ArrayList<SpecialAction> specialActions = new ArrayList<>();
    private Map<String, String> properties = new HashMap<>();

    public ActionObject() {
        properties.put("owner", "none");
        properties.put("name", "#unnamed");
        driver = new NullBehaviour(this);
    }

    public ActionObject(String name) {
        properties.put("owner", "none");
        properties.put("name", name);
        driver = new NullBehaviour(this);
    }

    public ActionObject(String name, Behaviour driver) {
        properties.put("owner", "none");
        properties.put("name", name);
        this.driver = driver;
    }

    /**
     * Метод добавления специального действия юнита к экземпляру
     *
     * @param specialAction класс специального действия
     */
    public void addSpecialAction(SpecialAction specialAction) {
        this.specialActions.add(specialAction);
    }

    /**
     * Метод удаления из экземпляра специального действия юнита
     *
     * @param specialAction класс специального действия
     */
    public void deleteSpecialAction(SpecialAction specialAction) {
        this.specialActions.remove(specialAction);
    }

    /**
     * Доступ к контейнеру действий
     *
     * @return контейнер для специальных действий экземпляра
     */
    public List<SpecialAction> getSpecialActions() {
        return specialActions;
    }

    /**
     * ЛДОступ к специальному действию экземпляра по имени
     *
     * @param name имя специального действия
     * @return специальное десйствие или null если его нет
     */
    public SpecialAction getSpecialActionByName(String name) {
        SpecialAction result = null;
        for (SpecialAction current : specialActions) {
            if (current.actionName() == name)
                return current;
        }
        return null;
    }

    /**
     * Метод добавленяи свойства к экземпляру
     *
     * @param name  имя свойства
     * @param value значение свойства
     */
    public void addProperty(String name, String value) {
        properties.put(name, value);
    }

    /**
     * Метод взятия свойства у экземпляра
     *
     * @param name имя свойства
     * @return значенеи свойства
     */
    public String getProperty(String name) {
        return properties.get(name);
    }

    /**
     * Метод выполнения действий экземпляром поведения, управляющим текущим экземпляром
     */
    public void doActions() {
        driver.doActions();
    }

    @Override
    public int compareTo(Object o) {
        return this.hashCode() - o.hashCode();
    }
}

