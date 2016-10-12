package util;

import actionObject.Cell;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class World {
    private Cell[][] world;
    private Random random;
    private GraphicalShell graphicalShell = new GraphicalShell();
    private ArrayList<Set<String>> players;


    public World(int width, int height) {
        world = new Cell[width][height];
        players = new ArrayList<>();
        random = new Random();

        for (int i = 0; i < width; i++) {
            for (int k = 0; k < height; k++) {
                world[i][k] = new Cell();
            }
        }
    }


}
