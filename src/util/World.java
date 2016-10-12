package util;

import actionObject.UnitComponent;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class World {
    private Cell[][] map;
    private ArrayList<Set<UnitComponent>> sides;

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

    public void Init(int players) {

        for (int i = 0; i < players; i++) {
            sides.add(new TreeSet<>());
        }
    }
}
