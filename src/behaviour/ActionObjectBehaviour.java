package behaviour;

import actionObject.ActionObject;
import behaviour.pipe.BehaviourCommand;
import behaviour.pipe.BehaviourNone;

public class ActionObjectBehaviour implements BehaviourInterface {
    private BehaviourCommand root;
    protected BehaviourCommand current;
    private ActionObject driven;

    public ActionObjectBehaviour(ActionObject driven){
        this.driven = driven;
    }

    @Override
    public void doActions() {
        current = getRoot();
        do {
            current = current.doAction();
        }while (current.getClass() != BehaviourNone.class);
    }

    @Override
    public ActionObject getDriven() {
        return this.driven;
    }

    @Override
    public void setDriven(ActionObject driven) {
        this.driven = driven;
    }

    public BehaviourCommand getRoot() {
        return root;
    }

    public void setRoot(BehaviourCommand root) {
        this.root = root;
    }
}
