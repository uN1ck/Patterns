package behaviour.pipe.builder;

import behaviour.pipe.BehaviourPipeline;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPipeBuilder {
    private List<BehaviourPipeline> behaviour = new ArrayList<>();

    /**
     * Основной метод фабрики, создающий экземпляр поведения с заданными параметрами
     *
     * @return экземпляр поведения
     */
    public abstract AbstractPipeBuilder buildBehaviour();

    /**
     * Метод клонирования объекта, используется для прототипирования фабрик
     *
     * @return Клон-экземпляр фабрики
     */
    public abstract AbstractPipeBuilder clone();


    /**
     * Метод добавления поведения к экземпляру фабрики
     *
     * @param behaviour Добавляемое поведение
     */
    public void addBehaviour(BehaviourPipeline behaviour) {
        this.behaviour.add(behaviour);
    }

    public List<BehaviourPipeline> getActions() {
        return behaviour;
    }

}
