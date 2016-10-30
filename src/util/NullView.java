package util;

import util.world.Cell;

import java.awt.*;

public class NullView implements ViewBridge {
    @Override
    public void drawCell(Cell value, Point position) {
        System.out.println("No view!");
    }
}
