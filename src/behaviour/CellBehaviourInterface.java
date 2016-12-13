package behaviour;

import actionObject.ActionObject;
import util.world.Cell;

public class CellBehaviourInterface implements BehaviourInterface {
    Cell driven;

    public CellBehaviourInterface(Cell driven) {
        this.driven = driven;
    }

    @Override
    public void doActions() {
        if (!driven.isEmpty())
            driven.getUnit().doActions();
    }

    @Override
    public ActionObject getDriven() {
        return driven;
    }

    @SuppressWarnings("uncheked")
    @Override
    public void setDriven(ActionObject driven) {
        this.driven = (Cell) driven;
    }
}
