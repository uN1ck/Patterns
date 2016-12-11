package behaviour;

import actionObject.ActionObject;

public interface BehaviourInterface {
    void doActions();

    ActionObject getDriven();

    void setDriven(ActionObject driven);
}
