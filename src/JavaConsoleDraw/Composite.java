package JavaConsoleDraw;

import java.util.List;

public interface Composite {
    void addChild(Composite child);

    List<Composite> getChildren();

    void removeChild(Composite child);

    void drawSelf();
}