package behaviour.pipe.builder;

import actionObject.ActionObject;
import behaviour.pipe.BehaviourPipeline;
import behaviour.pipe.BehaviourRootAction;

import java.util.ArrayList;

/**
 * Класс-строитель поведения юнитов
 */
public class BehaviourPipeBuilder extends AbstractPipeBuilder {

    public BehaviourPipeBuilder() {
    }

    /**
     * Основной метод фабрики, создающий экземпляр поведения с заданными параметрами
     *
     * @return экземпляр поведения
     */
    @Override
    public BehaviourPipeline buildBehaviour(ActionObject driven) {
        BehaviourPipeline root = new BehaviourRootAction();
        BehaviourPipeline current = root;
        for (BehaviourPipeline adding : this.behaviour) {
            current.addNext(adding);
            current = current.getNext();
        }
        return root;
    }

    /**
     * Метод клонирования объекта, используется для прототипирования фабрик
     *
     * @return Клон-экземпляр фабрики
     */
    @Override
    public AbstractPipeBuilder clone() {
        BehaviourPipeBuilder cloned = new BehaviourPipeBuilder();
        cloned.behaviour = new ArrayList<>(this.behaviour);
        return cloned;
    }
}
