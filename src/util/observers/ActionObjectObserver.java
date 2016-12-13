package util.observers;

import actionObject.ActionObject;

public interface ActionObjectObserver {
    void notifyEvent(ActionObject actionObject);
}
