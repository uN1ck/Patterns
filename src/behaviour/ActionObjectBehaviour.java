package behaviour;

import actionObject.ActionObject;

public class ActionObjectBehaviour implements BehaviourInterface{
    private ActionObject driven;

    @Override
    public void doActions() {

    }

    @Override
    public ActionObject getDriven() {
        return this.driven;
    }

    @Override
    public void setDriven(ActionObject driven) {
        this.driven = driven;
    }
}
