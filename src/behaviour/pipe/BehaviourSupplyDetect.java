package behaviour.pipe;

import actionObject.ActionObject;
import actionObject.actions.SpecialActionCarrySupplies;
import actionObject.actions.SpecialActionTransferSupply;
import util.world.Cell;
import util.world.World;
import util.world.WorldIterator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * классс комманды-состояния, задающий передвижение
 */
public class BehaviourSupplyDetect implements BehaviourCommand{
    private World world;
    private ActionObject owner;
    private BehaviourCommand moveToTarget;
    private BehaviourCommand moveDummy;

    /**
     * Метод вызывающий выполненеи комманды
     */
    @Override
    public BehaviourCommand doAction() {
        Queue<Cell> cellsque = new LinkedList<>();
        while (cellsque.size() > 0){
            if (((SpecialActionCarrySupplies)cellsque.peek().getSpecialActionByName(SpecialActionCarrySupplies.class.getName())).getValue() > 0)
                return moveToTarget;
        }
        return moveDummy;
    }

}
