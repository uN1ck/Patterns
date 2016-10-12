package actionObject.actions;

import actionObject.ActionObject;

/**
 * Интерфеййс активного специального действия юнита
 */
public interface SpecialAction {

    /**
     * Метод активного специального действия юнита
     * @param target Объект над которым выполняется действие
     * @param owner Объект выполняющий действие
     */
    void doAction(ActionObject target, ActionObject owner);

    /**
     * Метод определения идентификатора действия
     * @return Имя действия
     */
    String actionName();

}
