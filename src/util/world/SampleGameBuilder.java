package util.world;


import actionObject.ActionObject;
import actionObject.Builder.ActionObjectBuilder;
import actionObject.Builder.UnitBuilder;
import actionObject.actions.SpecialActionCreateAssultUnit;
import actionObject.actions.SpecialActionCreateSupplyUnit;
import actionObject.actions.SpecialActionGetSupplies;
import util.Game;

import java.util.*;

public class SampleGameBuilder implements GameBuilder {

    List<Set<ActionObject>> players = new ArrayList<>();
    private ActionObjectBuilder baseUnit = new UnitBuilder();

    public SampleGameBuilder() {

        players.add(new TreeSet<>());
        players.get(0).add(baseUnit.buildActionObject());
    }

    private void initFactories() {

        baseUnit.addAction(new SpecialActionGetSupplies(100), new HashMap<>());
        baseUnit.setProperty("SupplyMaximal", "1000");
        baseUnit.setProperty("SupplyCurrent", "1000");
        baseUnit.addAction(new SpecialActionCreateAssultUnit(), new HashMap<>());
        baseUnit.addAction(new SpecialActionCreateSupplyUnit(), new HashMap<>());

    }

    @Override
    public World createWorld() {
        World result = new World(3, 3);
        result.getCellByCoordinates(1, 1).tryPlaceUnit((ActionObject) players.get(0).toArray()[0]);
        return result;
    }

    @Override
    public List<Set<ActionObject>> createPlayers() {
        return players;
    }

    @Override
    public void createGame(Game instance) {

    }


}
