package actionObject;

import java.util.ArrayList;
import java.util.List;

public class Unit extends ActionObject implements UnitComponent {
    private UnitComponent owner;
    private ArrayList<UnitComponent> children;

    public Unit(UnitComponent owner) {
        super();
        this.owner = owner;
        children = new ArrayList<>();
    }

    @Override
    public UnitComponent getOwnership() {
        return owner;
    }

    @Override
    public void setOwnership(UnitComponent component) {
        owner = component;
    }

    @Override
    public List<UnitComponent> getChildren() {
        return children;
    }

    @Override
    public void addChild(UnitComponent component) {
        children.add(component);
    }


}
