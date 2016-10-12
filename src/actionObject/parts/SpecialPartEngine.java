package actionObject.parts;

public class SpecialPartEngine implements SpecialPart {
    private int speed;
    private String name = "PartBase";
    private int cost = 10;

    public SpecialPartEngine(int value) {
        this.speed = (value);
    }

    @Override
    public int setPropertyValue(int value) {
        speed = value;
        return speed;
    }

    @Override
    public int getPropertyValue(int value) {
        return speed;
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
