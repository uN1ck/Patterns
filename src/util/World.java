package util;

import actionObject.Cell;

import java.util.Random;

public class World {
    private Cell[][] world;
    private Random random = new Random();
    private GraphicalShell graphicalShell = new GraphicalShell();

    public World(int width, int height) {
        world = new Cell[width][height];


        for (int i = 0; i < width; i++) {
            for (int k = 0; k < height; k++) {
                world[i][k] = new Cell();
            }
        }

    }
}
