package unit;

import util.Behaviour;
import java.util.ArrayList;
import java.util.List;

/**
 * Базовый класс для юнита, содержащий в себе основные характеристики
 * Предполагается возможность сборки юнита "на ходу", т.е. набор свойств юнита
 * будет определяться непосредственно перед созданием и в процессе существования экземпляра динамически.
 */
public class Unit {
    private int health;
    private int speed;
    private Behaviour mananger;
    private String ownership;
    private ArrayList<UnitAction> unitActions;

    public Unit(int health, int speed, Behaviour mananger, String ownership, ArrayList unitActions) {
        setHealth(health);
        setSpeed(speed);
        setMananger(mananger);
        setOwnership(ownership);
        if (unitActions == null)
            unitActions = new ArrayList<>(unitActions);
        else
            unitActions = new ArrayList<>();
    }

    public Unit(Unit unit) {
        setHealth(unit.getHealth());
        setSpeed(unit.getSpeed());
        setMananger(unit.getMananger());
        setOwnership(unit.getOwnership());
        unitActions = new ArrayList<>(unit.getUnitActions());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Behaviour getMananger() {
        return mananger;
    }

    public void setMananger(Behaviour mananger) {
        this.mananger = mananger;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public void addUnitAction(UnitAction unitAction) {
        this.unitActions.add(unitAction);
    }

    public void deleteUnitAction(UnitAction unitAction) {
        this.unitActions.remove(unitAction);
    }

    public final List<UnitAction> getUnitActions() {
        return unitActions;
    }
}
