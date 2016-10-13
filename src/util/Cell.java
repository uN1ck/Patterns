package util;

import actionObject.ActionObject;

/**
 * Класс клетки игры. В клетке может находиться толкьо один текущий {@link ActionObject} (в дальнейшем юнит).
 * Класс отвечает за хранение юнита в текущей клетке и операции с ресурсами в текущей клетке.
 * Юнит в клетке может быть фиктивным и изображать препятсвие, мешающее перемещаться через эту клетку.
 */
public class Cell extends actionObject.ActionObject {
    private ActionObject unit = null;
    private World world;

    public Cell() {
        setUnit(null);
    }

    public ActionObject getUnit() {
        return unit;
    }

    public void setUnit(ActionObject unit) {
        this.unit = unit;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
