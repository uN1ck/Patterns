package actionObject.abstractFactory;

import actionObject.ActionObject;
import actionObject.actions.SpecialActionMove;
import actionObject.actions.SpecialActionShoot;
import actionObject.builder.UnitBuilder;
import util.world.World;

import java.util.HashMap;

/**
 * @deprecated
 */
public class AssaultUnitFactory implements AbstractFactory {
    private World worldLink;

    public AssaultUnitFactory(World value) {
        worldLink = value;
    }

    /**
     * Создать боевого юнита
     *
     * @return созданный юнит
     */
    @Override
    public ActionObject createUnit() {
        UnitBuilder assaultUnit = new UnitBuilder();
//        assaultUnit.addAction(new SpecialActionMove(worldLink, 5), new HashMap<>());
//        assaultUnit.setProperty("MoveMaximal", "5");
//        assaultUnit.setProperty("MoveRest", "5");
//        assaultUnit.addAction(new SpecialActionShoot(worldLink, 1, 5), new HashMap<>());
        return assaultUnit.buildActionObject();
    }
}
