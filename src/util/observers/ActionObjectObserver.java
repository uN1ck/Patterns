package util.observers;

import actionObject.ActionObject;

public interface ActionObjectObserver {
    public void notifyEvent(ActionObject actionObject);
}
