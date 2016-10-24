package javaFXEngine;

import java.util.List;

public interface GraphicComponent {
    List<GraphicComponent> getChildren();
    void addChild(GraphicComponent child);
    void drawSelf(int x, int y);
    void drawSelf();

}
