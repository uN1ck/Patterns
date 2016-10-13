package actionObject.actions;

import actionObject.ActionObject;
import util.World;

import java.awt.*;
import java.util.Set;
import java.util.TreeSet;

public class SpecialActionMove implements SpecialAction {
    private String name = "Move";
    private static String[] requiredProperties = {"MoveMaximal", "MoveRest"};
    private World world;

    public SpecialActionMove(World world) {
        this.world = world;
    }

    @Override
    public void doAction(ActionObject target, ActionObject owner) {
        Point position = world.getActionObjectCoordinates(owner);
        Point desiredPosition = world.getActionObjectCoordinates(target);
        Point nextPositinon = getNearestTo(desiredPosition, getAvailiblePoints(position));
        world.getCellByCoordinates(nextPositinon).setUnit(owner);
        world.getCellByCoordinates(position).setUnit(null);
    }

    private Set<Point> getAvailiblePoints(Point current) {
        Set<Point> result = new TreeSet<>();
        //TODO: Дописать поиск допустимых точек через БФС
        return result;
    }

    private Point getNearestTo(Point value, Set<Point> points) {
        //TODO: Дописать поиск ближайшей
        return null;
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
