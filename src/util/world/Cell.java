package util.world;

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
        super();
    }

    /**
     * Конструктор клетки, привязанной к миру
     *
     * @param world мир клетки
     */
    public Cell(World world) {
        super();
        this.world = world;
    }

    /**
     * Метод доступа к юниту в клетке
     *
     * @return юнит клетки
     */
    public ActionObject getUnit() {
        return unit;
    }

    /**
     * Метод попытки утсановки юнита в клетку если она не занята
     *
     * @param unit юнит, который следует поставить к летку
     * @return удалось ли поставить юнит
     */
    public boolean tryPlaceUnit(ActionObject unit) {
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

    public boolean isEmpty() {
        return unit == null;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

}
