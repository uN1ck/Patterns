package actionObject.builder;

import actionObject.ActionObject;
import actionObject.actions.SpecialAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Интерфейс фабрики создания юнитов, от которого наследуется прототипируемая фабрика
 */
public abstract class ActionObjectBuilder implements Cloneable {

    protected ArrayList<SpecialAction> actionTemplateList = new ArrayList<>();
    protected Map<String, String> propertiesTemplateList = new HashMap<>();
    protected Map<String, ArrayList<String>> actionToPropertyList = new HashMap<>();

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
     * @param action     Добавляемое действие
     * @param properties Свойства, требуемые для дейсвтия
     */
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


    public void setProperty(String name, String value) {
        propertiesTemplateList.put(name, value);
    }


    public String getProperty(String name) {
        return propertiesTemplateList.get(name);
    }


    public ArrayList<SpecialAction> getActions() {
        return actionTemplateList;
    }

}
