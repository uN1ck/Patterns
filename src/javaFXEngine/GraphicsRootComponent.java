package javaFXEngine;

import javafx.scene.canvas.GraphicsContext;
import util.Aggregation.Iterator;

import java.util.ArrayList;
import java.util.List;

public class GraphicsRootComponent extends GraphicsComponent {
    ArrayList<GraphicsComponent> children = new ArrayList<>();

    /**
     * Конструктор композита
     *
     * @param x      координата по x
     * @param y      координата по y
     * @param z      порядок отрисовки, определяющйи какой объект выше
     * @param width  ширина объекта
     * @param height высота объекта
     */
    public GraphicsRootComponent(int x, int y, int z, int width, int height) {
        super(x, y, z, width, height);
    }

    @Override
    public void drawSelf(GraphicsContext gc) {
        for (GraphicsComponent component : children) {
            component.drawSelf(gc);
        }
    }

    /**
     * Метод создания итератора для графических компонентов, корень итератора - корень иерархии,
     * текущее положение итератора - текущий класс
     *
     * @return итератор графических компонент
     */
    @Override
    public Iterator<GraphicsComponent> createIterator() {

        GraphicsComponent current = this;
        while (current.getParent() != current)
            current = this.getParent();

        return new GraphicsComponentsIterator(current);
    }

    @Override
    public List getList() {
        return children;
    }

    @Override
    public void add(GraphicsComponent value) {
        children.add(value);
    }

    @Override
    public void remove(GraphicsComponent value) {
        children.remove(value);
    }
}
