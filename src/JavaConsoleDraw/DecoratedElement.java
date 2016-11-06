package JavaConsoleDraw;

import java.util.ArrayList;
import java.util.List;

public class DecoratedElement implements Composite {
    Composite link;

    public DecoratedElement(Composite value) {
        this.link = link;
    }

    @Override
    public void addChild(Composite child) {

    }

    @Override
    public List<Composite> getChildren() {
        return new ArrayList<>();
    }

    @Override
    public void removeChild(Composite child) {

    }

    @Override
    public void drawSelf() {
        System.out.print("==DECORETED==");
        link.drawSelf();
    }
}
