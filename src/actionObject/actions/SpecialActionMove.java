package actionObject.actions;

import actionObject.ActionObject;
import util.world.World;

import java.awt.*;

public class SpecialActionMove extends SpecialAction {

    private World world;
    private int distance;

    /**
     * Конструктор действия передвижения юнита, использует мир для реализации
     *
     * @param world    мир
     * @param distance максимальное расстояние передвижения
     */
    public SpecialActionMove(World world, int distance) {
        this.world = world;
        this.distance = distance;
    }

    private Point findNearestAvailible(Point target, Point position) {
        Point result = (Point) position.clone();

        if (distance >= getDistance(position, target)) {
            return target;
        } else {
            double coef = distance / getDistance(position, target);
            result.x = (int) Math.round(Math.abs(position.x - target.x) * coef);
            result.y = (int) Math.round(Math.abs(position.y - target.y) * coef);
        }
        return result;

    }

    @Override
    public void doAction(ActionObject target, ActionObject owner) {
        Point position = world.getActionObjectCoordinates(owner);
        Point nextPositinon = findNearestAvailible(world.getActionObjectCoordinates(target), position);
        if (world.getCellByCoordinates(nextPositinon).tryPlaceUnit(owner))
            world.getCellByCoordinates(position).tryPlaceUnit(null);
    }

    private int getDistance(Point from, Point to) {
        return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
    }
}
