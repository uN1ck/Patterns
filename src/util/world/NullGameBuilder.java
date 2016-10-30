package util.world;

import actionObject.ActionObject;
import util.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NullGameBuilder implements GameBuilder {
    @Override
    public World createWorld() {
        return new World(0, 0);
    }

    @Override
    public List<Set<ActionObject>> createPlayers() {
        return new ArrayList<>();
    }

    @Override
    public void createGame(Game instance) {
        System.out.print("Null builder!");
    }
}
