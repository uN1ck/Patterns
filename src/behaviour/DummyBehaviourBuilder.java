package behaviour;

import actionObject.ActionObject;
import behaviour.pipe.BehaviourDummyMove;
import behaviour.pipe.BehaviourNone;
import util.world.World;

public class DummyBehaviourBuilder {

    public void createBehaviour(World world, ActionObject value){
        BehaviourDummyMove root = new BehaviourDummyMove(world, value);
        BehaviourNone next = new BehaviourNone();
        root.setNextCommand(next);
        ActionObjectBehaviour driver = new ActionObjectBehaviour(value);
        driver.setRoot(root);
        value.setDriver(driver);
    }
}
