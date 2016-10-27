package actionObject.actions;

import actionObject.ActionObject;
import util.World;

/**
 * Класс определяющий действие стрельбы от юнита по точке
 */
public class SpecialActionShoot implements SpecialAction {

    private static String name = "Shoot";
    private static String[] requiredProperties = {"ShootRange", "ShootDamage"};
    private World world;

    @Override
    public void doAction(ActionObject target, ActionObject owner) {
        if (getDistance(target, owner) < Integer.parseInt(owner.getProperty("ShootRange")))
            target.addProperty("Health", String.valueOf(Integer.parseInt(target.getProperty("Health")) - Integer.parseInt(owner.getProperty("ShootDamage"))));
    }

    private int getDistance(ActionObject target, ActionObject owner) {
        //TODO: дописать манхеттанское расстояние
        return 0;
    }

    @Override
    public String actionName() {
        return name;
    }

    @Override
    public String[] requiredProperties() {
        return requiredProperties;
    }

}
