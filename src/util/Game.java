package util;

import actionObject.ActionObject;
import util.world.Cell;
import util.world.GameBuilder;
import util.world.World;
import util.world.WorldIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Game {

    protected static Game instance;
    private World world;
    private List<Set<ActionObject>> players;
    private ViewBridge view;

    protected Game() {
        view = new NullView();
        players = new ArrayList<>();
        world = new World(0, 0);
    }

    /**
     * Статический метод инициализации и доступа к классу игры
     *
     * @return Экземпляр игры
     */
    static Game instance() {
        if (instance != null)
            return instance;
        else {
            instance = new Game();
            return instance;
        }
    }

    public void buildGame(GameBuilder builder) {
        this.world = builder.createWorld();
        this.players = builder.createPlayers();
    }

    void gameLoop(int ticks) {

        for (int i = 0; i < ticks; i++) {
            WorldIterator worldIterator = world.iterator();
            while (worldIterator.hasNext()) {
                Cell current = worldIterator.next();
                current.doActions();

                view.drawCell(current, worldIterator.getPosition());
            }
        }
    }

//
//    //TODO: перенести в метод
//    private ActionObjectBuilder baseUnit = new Builder();
//    private ActionObjectBuilder assaultUnit = new Builder();
//    private ActionObjectBuilder supplyUnit = new Builder();
//
//    private void initFactories() {
//        baseUnit.addAction(new SpecialActionMove(this), new HashMap<>());
//        assaultUnit = baseUnit.clone();
//        assaultUnit.setProperty("MoveMaximal", "5");
//        assaultUnit.setProperty("MoveRest", "5");
//        supplyUnit = assaultUnit.clone();
//
//        baseUnit.addAction(new SpecialActionGetSupplies(100), new HashMap<>());
//        baseUnit.setProperty("SupplyMaximal", "1000");
//        baseUnit.setProperty("SupplyCurrent", "1000");
//        baseUnit.addAction(new SpecialActionCreateAssultUnit(), new HashMap<>());
//        baseUnit.addAction(new SpecialActionCreateSupplyUnit(), new HashMap<>());
//
//        assaultUnit.addAction(new SpecialActionShoot(), new HashMap<>());
//        supplyUnit.addAction(new SpecialActionGetSupplies(100), new HashMap<>());
//        supplyUnit.setProperty("SupplyMaximal", "500");
//        supplyUnit.setProperty("SupplyCurrent", "500");
//
//    }
}
