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
    public void doAction(ActionObject target, ActionObject owner) throws Exception {
        Point position = world.getActionObjectCoordinates(owner);
        Point nextPositinon = world.getActionObjectCoordinates(target);

        if (world.getCellByCoordinates(nextPositinon).setUnit(owner) == false)
            throw new Exception("Can't move unit");

        world.getCellByCoordinates(position).setUnit(null);
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
