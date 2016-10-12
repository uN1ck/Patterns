package actionObject.parts;

/**
 * Класс описывающий корпус объекта, отвечает за прочность.
 * Имеет два собственных поля - максимальная и текущая прочности
 */
public class SpecialPartBase implements SpecialPart {
    private int healthPoints;
    private int health;
    private String name = "PartBase";
    private int cost = 10;

    public SpecialPartBase(int value) {
        this.health = value;
        this.healthPoints = value;
    }

    @Override
    public void tryGiveValue(int value) {
        healthPoints = (healthPoints + value) % (health + 1);
    }

    @Override
    public int tryGetValue(int value) {
        health = health - value;
        if (health < 0)
            health = 0;
        return (value % healthPoints + 1);
    }

    @Override
    public String partName() {
        return name;
    }

    @Override
    public int partCost() {
        return cost;
    }
}
