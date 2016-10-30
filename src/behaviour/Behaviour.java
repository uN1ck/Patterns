package behaviour;

import actionObject.ActionObject;

public interface Behaviour {
    void doActions();

    ActionObject getDriven();

    void setDriven(ActionObject driven);
}
