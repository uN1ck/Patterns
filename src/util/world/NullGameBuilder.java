package util.world;

import actionObject.ActionObject;
import util.game.GameBuilder;
import util.observers.ActionObjectObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NullGameBuilder implements GameBuilder {

    @Override
    public World getWorld() {
        return new World(0, 0);
    }

    @Override
    public List<Set<ActionObject>> getPlayers() {
        return new ArrayList<>();
    }

    @Override
    public ArrayList<ActionObjectObserver> getObservers() {
        return new ArrayList<>();
    }
}
