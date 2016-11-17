package actionObject.actions;

import actionObject.ActionObject;
import util.world.World;

import java.awt.*;

/**
 * Класс определяющий действие стрельбы от юнита по точке
 */
public class SpecialActionShoot extends SpecialAction {

    private World world;
    private int damage;
    private int range;

    /**
     * Конструктор оружия юнита, использующий доступ к миру игры для получения расстояния от себя до цели
     *
     * @param world  мир игры
     * @param damage урон
     * @param range  дальность стрельбы
     */
    public SpecialActionShoot(World world, int damage, int range) {
        this.world = world;
        this.damage = damage;
        this.range = range;
    }

    @Override
    public void doAction(ActionObject target, ActionObject owner) {
        if (getDistance(target, owner) < this.range) {

            SpecialAction targetSpecialAction = target.getSpecialActionByName(SpecialActionLive.class.getSimpleName());
            targetSpecialAction.doAction(owner, target);

        }
    }

    public int getDamage() {
        return damage;
    }

    private int getDistance(ActionObject target, ActionObject owner) {
        Point from = world.getActionObjectCoordinates(target);
        Point to = world.getActionObjectCoordinates(target);
        return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
    }
}
