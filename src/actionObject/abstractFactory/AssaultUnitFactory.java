package actionObject.abstractFactory;

import actionObject.ActionObject;
import actionObject.actions.*;
import actionObject.builder.ActionObjectBuilder;
import actionObject.builder.UnitBuilder;
import behaviour.DummyBehaviourBuilder;
import util.observers.ActionObjectObserver;
import util.world.World;

import java.util.HashMap;

public class AssaultUnitFactory implements AbstractFactory {
    private World worldLink;
    private ActionObjectObserver dieEventObserver;
    private ActionObjectBuilder assaultUnit;
    private DummyBehaviourBuilder behaviourBuilder = new DummyBehaviourBuilder();

    /**
     * Конструктор фабрики
     *
     * @param world            мир игры
     * @param dieEventObserver наблюдатель за состоянием здоровья юнитов
     */
    public AssaultUnitFactory(World world, ActionObjectObserver dieEventObserver) {
        worldLink = world;
        this.dieEventObserver = dieEventObserver;

        assaultUnit = new UnitBuilder();
        assaultUnit.addAction(new SpecialActionLive(100, dieEventObserver));
        assaultUnit.addAction(new SpecialActionMove(world,1));
    }

    /**
     * Создать абстрактного юнита
     *
     * @return созданный юнит
     */
    @Override
    public ActionObject createUnit() {
        ActionObject result = assaultUnit.buildActionObject();
        behaviourBuilder.createBehaviour(worldLink,result);
        return result;
    }
}