package actionObject.builder;

import actionObject.ActionObject;
import actionObject.actions.SpecialAction;

import java.util.ArrayList;

/**
 * Интерфейс фабрики создания юнитов, от которого наследуется прототипируемая фабрика
 */
public abstract class ActionObjectBuilder implements Cloneable {

    protected ArrayList<SpecialAction> actionTemplateList = new ArrayList<>();

    /**
     * Основной метод фабрики, создающий экземпляр юнита с заданными параметрами
     *
     * @return экземпляр юнита
     */
    public abstract ActionObject buildActionObject();

    /**
     * Метод клонирования объекта, используется для прототипирования фабрик
     *
     * @return Клон-экземпляр фабрики
     */
    public abstract ActionObjectBuilder clone();


    /**
     * Метод добавления действия к экземпляру фабрики
     *
     * @param action Добавляемое действие
     */
    public void addAction(SpecialAction action) {
        actionTemplateList.add(action);
    }

    public ArrayList<SpecialAction> getActions() {
        return actionTemplateList;
    }

}
