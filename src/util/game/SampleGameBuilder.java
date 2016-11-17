package util.game;


import actionObject.ActionObject;
import actionObject.abstractFactory.BaseUnitFactory;
import util.observers.ActionObjectObserver;
import util.observers.AliveObserver;
import util.world.World;

import java.util.*;

public class SampleGameBuilder implements GameBuilder {

    private World world;
    private List<Set<ActionObject>> players;
    private ArrayList<ActionObjectObserver> observers;
    private Random random = new Random();

    public SampleGameBuilder(int players, int width, int height, Game instance) {
        this.world = new World(width, height);
        this.players = new ArrayList<>();
        this.observers = new ArrayList<>();

        AliveObserver aliveObserver = new AliveObserver(instance);
        observers.add(aliveObserver);
        BaseUnitFactory baseFactory = new BaseUnitFactory(getWorld(), aliveObserver);

        for (int i = 0; i < players; i++) {
            this.getPlayers().add(new HashSet<>());
            ActionObject base = baseFactory.createUnit();
            this.getPlayers().get(i).add(base);

            while (true) {
                int x = Math.abs(random.nextInt()) % width;
                int y = Math.abs(random.nextInt()) % height;
                if (this.getWorld().getCellByCoordinates(x, y).tryPlaceUnit(base)) break;
            }
        }
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public List<Set<ActionObject>> getPlayers() {
        return players;
    }

    @Override
    public ArrayList<ActionObjectObserver> getObservers() {
        return observers;
    }
}
