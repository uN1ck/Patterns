package actionObject.parts;

/**
 * Класс адаптирующий класс хранилища ресурсов к общему интерфейсу "частей"
 */
public class SpecialPartTankAdapter implements SpecialPart {
    private SpecialPartTank tank;

    public SpecialPartTankAdapter(SpecialPartTank tank) {
        this.tank = tank;
    }

    @Override
    public int getPropertyValue(int value) {
        return tank.tryGetValue(value);
    }

    @Override
    public int setPropertyValue(int value) {
        return tank.tryGiveValue();
    }

    @Override
    public String partName() {
        return tank.partName();
    }

    @Override
    public int partCost() {
        return tank.partCost();
    }
}
