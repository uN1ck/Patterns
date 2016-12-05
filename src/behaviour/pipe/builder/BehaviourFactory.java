package behaviour.pipe.builder;

import actionObject.ActionObject;
import behaviour.pipe.BehaviourPipeline;

public interface BehaviourFactory {
    BehaviourPipeline createBehaviour(ActionObject driven);
}
