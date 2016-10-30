package actionObject.actions;

import actionObject.ActionObject;
import util.world.World;

import java.awt.*;

public class SpecialActionMove extends SpecialAction {
    private static String[] requiredProperties = {"MoveMaximal", "MoveRest"};
    private World world;

    public SpecialActionMove(World world) {
        this.world = world;
    }

    @Override
    public void doAction(ActionObject target, ActionObject owner) throws Exception {
        Point position = world.getActionObjectCoordinates(owner);
        Point nextPositinon = world.getActionObjectCoordinates(target);

        if (world.getCellByCoordinates(nextPositinon).tryPlaceUnit(owner) == false)
            throw new Exception("Can't move unit");

        world.getCellByCoordinates(position).tryPlaceUnit(null);
    }

    @Override
    public String[] requiredProperties() {
        return requiredProperties;
    }

}
