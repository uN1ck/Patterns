package behaviour.pipe;

import actionObject.ActionObject;
import util.world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Интерфейс коммнады поведения, является текущим состоянием в машине состояний поведения класса
 */
public interface BehaviourCommand {

    /**
     * Метод вызывающий выполненеи комманды
     */
    public abstract BehaviourCommand doAction();

}
