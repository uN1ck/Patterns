package behaviour.pipe.builder;

import actionObject.ActionObject;
import behaviour.pipe.BehaviourPipeline;

/**
 * Интерфейс фабрики по созданию конкретного типа поведения юнитов
 */
public interface BehaviourFactory {
    BehaviourPipeline createBehaviour(ActionObject driven);
}
