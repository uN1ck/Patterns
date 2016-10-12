package actionObject.parts;

public class SpecialPartEngine implements SpecialPart {
    private int speed;
    private String name ="PartBase";
    private int cost = 10;

    public SpecialPartEngine(int value) {
        this.speed = (value);
    }

    @Override
    public void tryGiveValue(int value) {

    }

    @Override
    public int tryGetValue(int value) {
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
