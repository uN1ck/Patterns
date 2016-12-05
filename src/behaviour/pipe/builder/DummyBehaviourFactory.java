package behaviour.pipe.builder;

import actionObject.ActionObject;
import behaviour.pipe.BehaviourDummyMove;
import behaviour.pipe.BehaviourPipeline;

/**
 * Класс строитель простого поведения передвежения юнитов
 */
public class DummyBehaviourFactory implements BehaviourFactory{

    private BehaviourPipeBuilder dummyBehaviourBuilder = new BehaviourPipeBuilder();

    @Override
    public BehaviourPipeline createBehaviour(ActionObject driven) {
        dummyBehaviourBuilder.addBehaviour(new BehaviourDummyMove());
        return dummyBehaviourBuilder.buildBehaviour(driven);
    }
}
