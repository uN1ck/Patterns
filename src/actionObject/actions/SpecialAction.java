package actionObject.actions;

import actionObject.ActionObject;

/**
 * Интерфеййс активного специального действия юнита
 */
public abstract class SpecialAction {

    /**
     * Метод активного специального действия юнита
     *
     * @param target Объект над которым выполняется действие
     * @param owner  Объект выполняющий действие
     */
    public abstract void doAction(ActionObject target, ActionObject owner) throws Exception;

    /**
     * Метод определения идентификатора действия
     *
     * @return Имя действия
     */
    public String actionName() {
        return this.getClass().getSimpleName();
    }

    /**
     * Метод определяющий какие свойства у объектаДействия должны быть,
     * для корректной работы данного действия при добавлении
     *
     * @return список названий свойств
     */
    public abstract String[] requiredProperties();

}
