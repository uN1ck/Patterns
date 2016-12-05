package behaviour.pipe;

import actionObject.actions.SpecialActionMove;

import java.util.Random;

public class BehaviourDummyMove extends BehaviourPipeline {
    Random rand = new Random();

    @Override
    protected void doAction() {
        SpecialActionMove move = (SpecialActionMove) this.driven.getSpecialActionByName(SpecialActionMove.class.getSimpleName());
        move.doAction(this.world.getCellByCoordinates(world.getSizes().x, world.getSizes().y), driven);
    }
}
