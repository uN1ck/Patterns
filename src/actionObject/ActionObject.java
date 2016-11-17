package actionObject;

import actionObject.actions.SpecialAction;
import behaviour.Behaviour;
import behaviour.NullBehaviour;

import java.util.ArrayList;
import java.util.List;

public class ActionObject implements Comparable {
    Behaviour driver;
    private ArrayList<SpecialAction> specialActions = new ArrayList<>();

    public ActionObject() {
        driver = new NullBehaviour(this);
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
     * Доступ к специальному действию экземпляра по имени
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

