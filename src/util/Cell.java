package util;

import actionObject.ActionObject;

/**
 * Класс клетки игры. В клетке может находиться толкьо один текущий {@link ActionObject} (в дальнейшем юнит).
 * Класс отвечает за хранение юнита в текущей клетке и операции с ресурсами в текущей клетке.
 * Юнит в клетке может быть фиктивным и изображать препятсвие, мешающее перемещаться через эту клетку.
 */
public class Cell extends ActionObject {
    private ActionObject unit = null;
    private World world;

    public Cell() {
        setUnit(null);
    }

    public ActionObject getUnit() {
        return unit;
    }

    public boolean setUnit(ActionObject unit) {
        if (unit == null) {
            this.unit = null;
            return true;
        }
        if (this.unit == null) {
            this.unit = unit;
            return true;
        }
        return false;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public String toString() {
        String result = "Cell content:\n";
        if (unit != null)
            result += unit.toString();
        else
            result += "NONE";
        return result;
    }
}
