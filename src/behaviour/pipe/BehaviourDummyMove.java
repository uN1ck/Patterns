package behaviour.pipe;

import actionObject.ActionObject;
import actionObject.actions.SpecialActionMove;
import util.world.World;

import java.awt.*;
import java.util.Random;

/**
 * Класс-состояние поведения, описывающий произвольнео движение юнита, требует обязательно наличие у подконтрольного
 * требуемого специального действия
 */
public class BehaviourDummyMove implements BehaviourCommand {
    private World world;
    private SpecialActionMove movement;
    private ActionObject driven;
    private BehaviourCommand nextCommand;
    private Random rand = new Random();

    public BehaviourDummyMove(World world, ActionObject driven) {
        this.world = world;
        this.driven = driven;
        movement = (SpecialActionMove) this.driven.getSpecialActionByName(SpecialActionMove.class.getSimpleName());
    }

    @Override
    public BehaviourCommand doAction() {
        int x = rand.nextInt(world.getSizes().x);
        int y = rand.nextInt(world.getSizes().y);
        Point from = world.getActionObjectCoordinates(driven);

        //TODO: Remove debug
        System.out.print("Object: " + this.hashCode()+": ");

        movement.doAction(this.world.getCellByCoordinates(x, y), driven);
        return this.getNextCommand();
    }

    public BehaviourCommand getNextCommand() {
        return nextCommand;
    }

    public void setNextCommand(BehaviourCommand nextCommand) {
        this.nextCommand = nextCommand;
    }
}
