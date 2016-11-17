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

    @Override
    public void doAction(ActionObject target, ActionObject owner) {
        Point position = world.getActionObjectCoordinates(owner);
        Point nextPositinon = world.getActionObjectCoordinates(target);
        if (distance >= getDistance(position, nextPositinon))
            if (world.getCellByCoordinates(nextPositinon).tryPlaceUnit(owner))
                world.getCellByCoordinates(position).tryPlaceUnit(null);
    }

    private int getDistance(Point from, Point to) {
        return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
    }
}
