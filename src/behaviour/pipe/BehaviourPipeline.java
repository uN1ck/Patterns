package behaviour.pipe;

import actionObject.ActionObject;
import util.world.World;

/**
 * Класс цепочка обяззаностей, определяющея поведение объекта,
 * предполагается очередность примерно такая:
 * 1) Передвижение
 * 2) Стрельба / сбор ресурсов
 */
public abstract class BehaviourPipeline {
    protected ActionObject driven;
    protected World world;
    private BehaviourPipeline next;

    public void addNext(BehaviourPipeline behaviour) {
        next = behaviour;
    }

    public BehaviourPipeline getNext() {
        return next;
    }

    public void append(BehaviourPipeline behaviour) {
        if (next != null)
            next.append(behaviour);
        else
            next = behaviour;
    }

    protected abstract void doAction();

    public void doActions() {
        BehaviourPipeline current = this;
        while (current != null) {
            current.doAction();
            current = current.getNext();
        }
    }

    public ActionObject getDriven() {
        return driven;
    }

    public void setDriven(ActionObject driven) {
        this.driven = driven;
    }
}
