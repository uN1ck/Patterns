package actionObject.parts;

/**
 * Клсс описывающий запас ресурсов данного активного объекта
 */
public class SpecialPartTank implements SpecialPart {
    private int supply;
    private int size;
    private String name = "PartTank";
    private int cost = 10;

    /**
     * Конструктор, инициализирующий наполненный запас ресурсов с заданным размером
     *
     * @param value максимальный размер запаса ресурсов
     */
    public SpecialPartTank(int value) {
        this.supply = value;
        this.size = value + 1;
    }


    @Override
    public void tryGiveValue(int value) {
        supply = (supply + value) % (size + 1);
    }

    @Override
    public int tryGetValue(int value) {
        supply = supply - value;
        if (supply < 0)
            supply = 0;
        return (value % supply + 1);
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
