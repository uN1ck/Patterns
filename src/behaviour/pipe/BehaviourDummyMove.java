package behaviour.pipe;

import actionObject.ActionObject;
import actionObject.actions.SpecialActionMove;
import util.world.World;

/**
 * Класс-состояние поведения, описывающий произвольнео движение юнита, требует обязательно наличие у подконтрольного
 * требуемого специального действия
 */
public class BehaviourDummyMove implements BehaviourCommand {
    private World world;
    private SpecialActionMove movement;
    private ActionObject driven;
    private BehaviourCommand nextCommand;

    public BehaviourDummyMove(World world, ActionObject driven) {
        this.world = world;
        this.driven = driven;
        movement = (SpecialActionMove) this.driven.getSpecialActionByName(SpecialActionMove.class.getSimpleName());
    }

    @Override
    public BehaviourCommand doAction() {
        movement.doAction(this.world.getCellByCoordinates(world.getSizes().x, world.getSizes().y), driven);
        return this.getNextCommand();
    }

    public BehaviourCommand getNextCommand() {
        return nextCommand;
    }

    public void setNextCommand(BehaviourCommand nextCommand) {
        this.nextCommand = nextCommand;
    }
}
