package util;

import actionObject.ActionObject;
import actionObject.UnitFactory.BasicActionObjectFactory;
import actionObject.UnitFactory.UnitFactory;
import actionObject.actions.*;
import util.Aggregation.Aggregator;
import util.Aggregation.Iterator;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Класс-фасад для логики игры, орагнизует хранение всех игровых объектов и дает доступ к ним только через свой интерфейс
 * Так-же является единственным возможным экземпляром
 */
public class World implements Aggregator<Cell>{
    private static World self;
    private Cell[][] map;
    private ArrayList<Set<ActionObject>> sides;


    //TODO: перенести в метод
    private BasicActionObjectFactory baseUnit = new UnitFactory();
    private BasicActionObjectFactory assaultUnit = new UnitFactory();
    private BasicActionObjectFactory supplyUnit = new UnitFactory();

    public World(int width, int height, int playersCount, ViewBridge view) {
        sides = new ArrayList<>();
        map = new Cell[width][height];

        for (int i = 0; i < width; i++) {
            for (int k = 0; k < height; k++) {
                map[i][k] = new Cell();
                map[i][k].setWorld(this);
            }
        }

        Init(playersCount);
        this.view = view;
    }

    public Point getActionObjectCoordinates(ActionObject value) {
        return new Point(0, 0);
    }

    public Cell getCellByCoordinates(Point value) {
        return null;
    }

    public void Init(int players) {
        initFactories();
        Random rand = new Random();
        for (int i = 0; i < players; i++) {
            sides.add(new TreeSet<>());

            placeUnit(baseUnit.buildActionObject(), rand, i);
            placeUnit(supplyUnit.buildActionObject(), rand, i);
            placeUnit(assaultUnit.buildActionObject(), rand, i);
        }
    }

    private void placeUnit(ActionObject unit, Random rand, int playerIndex) {
        int x = 0;
        int y = 0;
        do {
            x = Math.abs(rand.nextInt()) % map.length;
            y = Math.abs(rand.nextInt()) % map.length;
        } while (map[x][y].setUnit(unit) != false);

        sides.get(playerIndex).add(unit);
    }

    private void initFactories() {
        baseUnit.addAction(new SpecialActionMove(this), new HashMap<>());
        assaultUnit = baseUnit.clone();
        assaultUnit.setProperty("MoveMaximal", "5");
        assaultUnit.setProperty("MoveRest", "5");
        supplyUnit = assaultUnit.clone();

        baseUnit.addAction(new SpecialActionGetSupplies(100), new HashMap<>());
        baseUnit.setProperty("SupplyMaximal", "1000");
        baseUnit.setProperty("SupplyCurrent", "1000");
        baseUnit.addAction(new SpecialActionCreateAssultUnit(), new HashMap<>());
        baseUnit.addAction(new SpecialActionCreateSupplyUnit(), new HashMap<>());

        assaultUnit.addAction(new SpecialActionShoot(), new HashMap<>());
        supplyUnit.addAction(new SpecialActionGetSupplies(100), new HashMap<>());
        supplyUnit.setProperty("SupplyMaximal", "500");
        supplyUnit.setProperty("SupplyCurrent", "500");

    }

    @Override
    public Iterator<Cell> createIterator() {
        return null;
    }

    @Override
    public List getList() {
        return null;
    }

    @Override
    public void add(Cell value) {

    }

    @Override
    public void remove(Cell value) {

    }
}
