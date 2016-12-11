package behaviour;

import actionObject.ActionObject;

public class SupplyBehaviourInterface implements BehaviourInterface {
    ActionObject driven;
    зкщеусеув BehaviourPipeline root;

    public SupplyBehaviourInterface() {
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
        this.driven = driven;
    }
}
