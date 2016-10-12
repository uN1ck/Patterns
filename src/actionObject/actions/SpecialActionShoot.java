package actionObject.actions;

import actionObject.ActionObject;

/**
 * Класс определяющий действие стрельбы от юнита по точке
 */
public class SpecialActionShoot implements SpecialAction {

    private static String name = "Shoot";

    @Override
    public void doAction(ActionObject target, ActionObject owner) {

    }

    @Override
    public String actionName() {
        return name;
    }

}
