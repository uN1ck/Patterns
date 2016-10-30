package behaviour;

import actionObject.ActionObject;
import util.world.Cell;

public class CellBehaviour implements Behaviour {
    Cell driven;

    public CellBehaviour(Cell Driven) {
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
