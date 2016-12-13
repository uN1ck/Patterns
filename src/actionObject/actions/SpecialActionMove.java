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
            double coef = distance / ((double) getDistance(position, target));
            result.x = position.x + (int) Math.round((target.x - position.x) * coef);
            result.y = position.y + (int) Math.round((target.y - position.y) * coef);
            if (result.x >= world.getSizes().x) result.x = world.getSizes().x - 1;
            if (result.x < 0) result.x = 0;
            if (result.y >= world.getSizes().y) result.y = world.getSizes().y - 1;
            if (result.y < 0) result.y = 0;
        }
        return result;

    }

    @Override
    public void doAction(ActionObject target, ActionObject owner) {
        Point position = world.getActionObjectCoordinates(owner);
        Point nextPosition = findNearestAvailible(world.getActionObjectCoordinates(target), position);

        //TODO: Remove debug
        System.out.print("Request to move from(" + position.toString() + ") to (" + nextPosition.toString() + ") ");
        if (world.getCellByCoordinates(nextPosition).tryPlaceUnit(owner)) {
            //TODO: Remove debug
            System.out.print(" is accepted\n");
            world.getCellByCoordinates(position).tryPlaceUnit(null);
        } else {
            //TODO: Remove debug
            System.out.print(" DENIED!\n");
        }
    }

    private int getDistance(Point from, Point to) {
        return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
    }
}
