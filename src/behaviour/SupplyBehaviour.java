package behaviour;

import actionObject.ActionObject;
import behaviour.pipe.BehaviourPipeline;

public class SupplyBehaviour implements Behaviour {
    ActionObject driven;
    BehaviourPipeline root;

    public SupplyBehaviour() {
        driven = null;
    }

    @Override
    public void doActions() {

    }

    @Override
    public ActionObject getDriven() {
        return null;
    }

    @Override
    public void setDriven(ActionObject driven) {

    }
}
