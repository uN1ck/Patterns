package util.world;

import actionObject.ActionObject;
import behaviour.CellBehaviourInterface;

import java.awt.*;

public class World implements Iterable<Cell> {
    private Cell[][] map;

    public World(int width, int height) {
        map = new Cell[width][height];

        for (int i = 0; i < width; i++) {
            for (int k = 0; k < height; k++) {
                map[i][k] = new Cell();
                map[i][k].setWorld(this);
                map[i][k].setDriver(new CellBehaviourInterface(map[i][k]));
            }
        }
    }

    /**
     * Метод доступа к координатам по объекту
     *
     * @param value искомый объект
     * @return координаты искомого объекта
     */
    public Point getActionObjectCoordinates(ActionObject value) {
        WorldIterator worldIterator = this.iterator();
        while (worldIterator.hasNext()) {
            Cell current = worldIterator.next();

            if (((!current.isEmpty()) && value == current.getUnit()) || value == current)
                return worldIterator.getPosition();
        }
        return new Point(0, 0);
    }

    /**
     * Метод доступа к объекту по координатам
     *
     * @param value координатная точка
     * @return объект в точке
     */
    public Cell getCellByCoordinates(Point value) {
        return map[value.x][value.y];
    }

    /**
     * Метод доступа к объекту по координатам, альтернатива методу {@link #getCellByCoordinates(Point)}
     *
     * @param x координата объекта
     * @param y координата объекта
     * @return объект в точке
     */
    public Cell getCellByCoordinates(int x, int y) {
        return map[x][y];
    }

    /**
     * Метод к доступу значений ширины и высоты мира
     *
     * @return точка с шириной и высотой мира
     */
    public Point getSizes() {
        if (map.length > 0) {
            return new Point(map.length, map[0].length);
        }
        return new Point(0, 0);
    }

    @Override
    public WorldIterator iterator() {
        return new WorldIterator(this);
    }
}
