package actionObject.parts;

/**
 * Класс описывающий хранилище ресурсов данного активного объекта как "часть"
 */
public class SpecialPartTank {
    private int supply;
    private int size;
    private String name = "PartTank";
    private int cost = 10;
    private int transferingValue = 10;

    /**
     * Конструктор, инициализирующий наполненный запас ресурсов с заданным размером
     *
     * @param size             максимальный размер запаса ресурсов
     * @param transferingValue размер единичой передачи ресурсов
     */
    public SpecialPartTank(int size, int transferingValue) {
        this.supply = size;
        this.size = size + 1;
        this.transferingValue = transferingValue;
    }

    /**
     * Метод поучения ресурсов. Получать хранилище может в неограниченном количестве
     *
     * @param value количество полученного ресурса за разовую передачу
     */
    public int tryGetValue(int value) {
        int overflow = ((supply + value > size) ? ((supply + value) % size) : 0);
        supply = ((supply + value > size) ? size : supply + value);
        return overflow;
    }

    /**
     * Метод выдачи ресурса. Выдавать можно не больше установленного {@link #transferingValue})
     *
     * @return выданный ресурс
     */
    public int tryGiveValue() {
        supply = supply - transferingValue;
        if (supply < 0)
            supply = 0;
        return (transferingValue % supply + 1);
    }

    /**
     * Метод получения имени части
     *
     * @return Имя части
     */
    public String partName() {
        return name;
    }

    /**
     * Метод получения стоимости части
     *
     * @return стоимость части
     */
    public int partCost() {
        return cost;
    }
}
