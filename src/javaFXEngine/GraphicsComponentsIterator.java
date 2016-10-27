package javaFXEngine;

import util.Aggregation.Iterator;

public class GraphicsComponentsIterator implements Iterator<GraphicsComponent> {
    GraphicsComponent root = null;
    GraphicsComponent current = null;

    public GraphicsComponentsIterator(GraphicsComponent root) {
        this.root = root;
        this.current = this.root;
    }

    public GraphicsComponentsIterator(GraphicsComponent root, GraphicsComponent current) {
        this.root = root;
        this.current = current;
    }

    @Override
    public void First() {
        this.current = root;
    }

    @Override
    public boolean Next() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public GraphicsComponent getItem() {
        return current;
    }
}
