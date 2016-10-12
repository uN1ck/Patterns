package actionObject;


import java.util.List;

public interface ActionObjectComponent {

    ActionObjectComponent getOwnership();

    List<ActionObjectComponent> getChildren();

    void addChild(ActionObjectComponent component);
}
