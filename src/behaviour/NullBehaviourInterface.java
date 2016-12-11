package behaviour;

import actionObject.ActionObject;

public class NullBehaviourInterface implements BehaviourInterface {
    private ActionObject driven;

    public NullBehaviourInterface(ActionObject driven) {
        this.driven = driven;
    }

    @Override
    public void doActions() {
        System.out.println("Doing actions of " + driven.getClass().getSimpleName() + "(" + driven.hashCode() + ")");
    }

    @Override
    public ActionObject getDriven() {
        return driven;
    }

    @Override
    public void setDriven(ActionObject driven) {
        this.driven = driven;
    }
}
