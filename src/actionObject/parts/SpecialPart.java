package actionObject.parts;

public interface SpecialPart {

    void tryGiveValue(int value);

    int tryGetValue(int value);

    String partName();

    int partCost();
}

