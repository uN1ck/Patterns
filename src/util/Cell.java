package util;

import actionObject.UnitComponent;

/**
 * Класс клетки игры. В клетке может находиться толкьо один текущий {@link UnitComponent} (в дальнейшем юнит), предком клетки является (?),
 * Детьми клетки являются соседи клетки, т.е. места, доступные к перемещению от текущей.
 * Классотвечает за хранение юнита в текущей клетке и операции с ресурсами в текущей клетке.
 * Юнит в клетке может быть фиктивным и изображать препятсвие, мешающее перемещаться через эту клетку.
 */
public class Cell extends actionObject.ActionObject {
    private UnitComponent unit = null;
    private World world;

    public Cell() {
        setUnit(null);
    }

    public UnitComponent getUnit() {
        return unit;
    }

    public void setUnit(UnitComponent unit) {
        this.unit = unit;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
