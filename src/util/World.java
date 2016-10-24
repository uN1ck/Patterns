package util;

import actionObject.ActionObject;
import actionObject.UnitFactory.BasicActionObjectFactory;
import actionObject.UnitFactory.ConcreteUnitFactory;
import actionObject.actions.*;

import java.awt.*;
import java.util.*;

public class World {
    private Cell[][] map;
    private ArrayList<Set<ActionObject>> sides;
    private GraphicsController graphicsControllerBridge;

    //TODO: перенести в метод
    private BasicActionObjectFactory baseUnit = new ConcreteUnitFactory();
    private BasicActionObjectFactory assaultUnit = new ConcreteUnitFactory();
    private BasicActionObjectFactory supplyUnit = new ConcreteUnitFactory();

    public World(int size) {
        sides = new ArrayList<>();
        map = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                map[i][k] = new Cell();
                map[i][k].setWorld(this);
            }
        }
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
    public String toString() {
        String result = "";
        for (int i = 0; i < map.length; i++) {
            for (int k = 0; k < map.length; k++) {
                result += "position(" + i + "," + k + ") \nvalue: \n" + map[i][k].toString() + "\n\n";
            }
        }
        return result;
    }
}
