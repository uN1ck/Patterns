package util.world;


import java.awt.*;
import java.util.Iterator;

/**
 * Итератор клеток мира
 */
public class WorldIterator implements Iterator<Cell> {
    World collectionLink;
    int index = 0;

    public WorldIterator(World worldLink) {
        this.collectionLink = worldLink;
    }

    @Override
    public boolean hasNext() {
        return index < collectionLink.getSizes().x * collectionLink.getSizes().y;
    }

    @Override
    public Cell next() {
        if (hasNext())
            return collectionLink.getCellByCoordinates(index / collectionLink.getSizes().x, index % collectionLink.getSizes().y);
        else
            throw new NullPointerException("Has not next element");
    }

    public Point getPosition() {
        return new Point(index / collectionLink.getSizes().x, index % collectionLink.getSizes().y);
    }
}
