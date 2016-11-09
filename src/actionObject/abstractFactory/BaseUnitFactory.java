package actionObject.abstractFactory;

import actionObject.ActionObject;
import actionObject.actions.SpecialActionCreateAssultUnit;
import actionObject.actions.SpecialActionCreateSupplyUnit;
import actionObject.actions.SpecialActionGetSupplies;
import actionObject.actions.SpecialActionMove;
import actionObject.builder.ActionObjectBuilder;
import actionObject.builder.UnitBuilder;
import util.world.World;

import java.util.HashMap;

public class BaseUnitFactory implements AbstractFactory {
    private World worldLink;

    public BaseUnitFactory(World value) {
        worldLink = value;
    }

    /**
     * Создать абстрактного юнита
     *
     * @return созданный юнит
     */
    @Override
    public ActionObject createUnit() {
        ActionObjectBuilder baseUnit = new UnitBuilder();
        baseUnit.addAction(new SpecialActionMove(worldLink), new HashMap<>());
        baseUnit.addAction(new SpecialActionGetSupplies(100), new HashMap<>());
        baseUnit.setProperty("SupplyMaximal", "1000");
        baseUnit.setProperty("SupplyCurrent", "1000");
        baseUnit.addAction(new SpecialActionCreateAssultUnit(), new HashMap<>());
        baseUnit.addAction(new SpecialActionCreateSupplyUnit(), new HashMap<>());
        return null;
    }
}