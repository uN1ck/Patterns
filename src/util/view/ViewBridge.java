package util.view;

import util.world.Cell;

import java.awt.*;

public interface ViewBridge {

    void drawCell(Cell value, Point position);
}
