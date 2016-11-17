package util.game;

import actionObject.ActionObject;
import util.observers.ActionObjectObserver;
import util.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Set;

public interface GameBuilder {
    World getWorld();

    List<Set<ActionObject>> getPlayers();

    ArrayList<ActionObjectObserver> getObservers();
}
