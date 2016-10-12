package actionObject;

import actionObject.actions.SpecialAction;
import actionObject.parts.SpecialPart;

import java.util.ArrayList;
import java.util.List;

public abstract class ActionObject {
    private ArrayList<SpecialAction> specialActions = new ArrayList<>();
    private ArrayList<SpecialPart> specialParts = new ArrayList<>();

    //

    public void addSpecialAction(SpecialAction specialAction) {
        this.specialActions.add(specialAction);
    }

    public void deleteSpecialAction(SpecialAction specialAction) {
        this.specialActions.remove(specialAction);
    }

    public List<SpecialAction> getSpecialActions() {
        return specialActions;
    }

    public SpecialAction getSpecialActionByName(String name) {
        SpecialAction result = null;
        for (SpecialAction current : specialActions) {
            if (current.actionName() == name)
                result = current;
        }
        return result;
    }

    //

    public void addSpecialPart(SpecialPart specialPart) {
        this.specialParts.add(specialPart);
    }

    public void deleteSpecialPart(SpecialPart specialPart) {
        this.specialParts.remove(specialPart);
    }

    public List<SpecialPart> getSpecialPart() {
        return specialParts;
    }

    public SpecialPart getSpecialPartByName(String name) {
        SpecialPart result = null;
        for (SpecialPart current : specialParts) {
            if (current.partName() == name)
                result = current;
        }
        return result;
    }
    
}

