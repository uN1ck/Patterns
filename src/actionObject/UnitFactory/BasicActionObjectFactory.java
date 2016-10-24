package actionObject.UnitFactory;

import actionObject.ActionObject;
import actionObject.actions.SpecialAction;

import java.util.ArrayList;
import java.util.Map;

/**
 * Интерфейс фабрики создания юнитов, от которого наследуется прототипируемая фабрика
 */
public interface BasicActionObjectFactory extends Cloneable {

    /**
     * Основной метод фабрики, создающий экземпляр юнита с заданными параметрами
     *
     * @return экземпляр юнита
     */
    ActionObject buildActionObject();

    /**
     * Метод добавления действия к экземпляру фабрики
     *
     * @param action     Добавляемое действие
     * @param properties Свойства, требуемые для дейсвтия
     */
    void addAction(SpecialAction action, Map<String, String> properties);

    void setProperty(String name, String value);

    String getProperty(String name);

    /**
     * Метод клонирования объекта, используется для прототипирования фабрик
     *
     * @return Клон-экземпляр фабрики
     */
    BasicActionObjectFactory clone();

    ArrayList<SpecialAction> getActions();

}
