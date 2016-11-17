package actionObject.abstractFactory;

import actionObject.ActionObject;
import actionObject.actions.*;
import actionObject.builder.ActionObjectBuilder;
import actionObject.builder.UnitBuilder;
import util.observers.ActionObjectObserver;
import util.world.World;

/**
 * Экземпляр фабрики по созданию типовой базы игрока
 */
public class BaseUnitFactory implements AbstractFactory {
    private World worldLink;
    private ActionObjectObserver dieEventObserver;
    private ActionObjectBuilder baseUnit;

    /**
     * Конструктор фабрики
     *
     * @param world            мир игры
     * @param dieEventObserver наблюдатель за состоянием здоровья юнитов
     */
    public BaseUnitFactory(World world, ActionObjectObserver dieEventObserver) {
        worldLink = world;
        this.dieEventObserver = dieEventObserver;

        baseUnit = new UnitBuilder();
        baseUnit.addAction(new SpecialActionLive(100, dieEventObserver));
        baseUnit.addAction(new SpecialActionCarrySupplies(10000, 10000));
        baseUnit.addAction(new SpecialActionTransferSupply(100));
        baseUnit.addAction(new SpecialActionCreateAssultUnit());
        baseUnit.addAction(new SpecialActionCreateSupplyUnit());
    }

    /**
     * Создать абстрактного юнита
     *
     * @return созданный юнит
     */
    @Override
    public ActionObject createUnit() {
        return baseUnit.buildActionObject();
    }
}