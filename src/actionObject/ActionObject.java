package actionObject;

import actionObject.actions.SpecialAction;
import actionObject.parts.SpecialPart;

import java.util.ArrayList;
import java.util.List;

public class ActionObject implements ActionObjectComponent {
    private ArrayList<SpecialAction> specialActions;
    private ArrayList<SpecialPart> specialParts;
    private ActionObjectComponent owner;
    private ArrayList<ActionObjectComponent> children;

    public ActionObject() {
        specialActions = new ArrayList<>();
        specialParts = new ArrayList<>();
        children = new ArrayList<>();
        owner = null;
    }

    public ActionObject(ActionObjectComponent owner) {
        specialActions = new ArrayList<>();
        specialParts = new ArrayList<>();
        this.owner = owner;
    }


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


    public ActionObjectComponent getOwnership() {
        return owner;
    }

    @Override
    public List<ActionObjectComponent> getChildren() {
        return children;
    }

    @Override
    public void addChild(ActionObjectComponent component) {
        children.add(component);
    }

}

