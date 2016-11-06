package JavaConsoleDraw;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GlobalScene implements Composite {
    ArrayList<Composite> children;

    public GlobalScene() {
        children = new ArrayList<>();
    }

    @Override
    public void addChild(Composite child) {
        children.add(child);
    }

    @Override
    public List<Composite> getChildren() {
        return children;
    }

    @Override
    public void removeChild(Composite child) {
        children.remove(child);
    }

    @Override
    public void drawSelf() {
        for (Composite current : children) {
            current.drawSelf();
        }
    }
}
