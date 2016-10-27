package javaFXEngine;

import javafx.scene.canvas.GraphicsContext;
import util.Aggregation.Aggregator;

/**
 * Абстрактный класс-композит для всех графических элементов игры
 */
public abstract class GraphicsComponent implements Aggregator<GraphicsComponent> {
    public int x;
    public int y;
    public int z;
    public int width;
    public int height;
    private GraphicsComponent parent;

    /**
     * Конструктор композита
     *
     * @param x      координата по x
     * @param y      координата по y
     * @param z      порядок отрисовки, определяющйи какой объект выше
     * @param width  ширина объекта
     * @param height высота объекта
     */
    public GraphicsComponent(int x, int y, int z, int width, int height) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
        this.setParent(this);
    }

    /**
     * Метод отрисовки текущего экземпляра
     * @param gc графический контекст отрисовки
     */
    public abstract void drawSelf(GraphicsContext gc);


    public GraphicsComponent getParent() {
        return parent;
    }

    public void setParent(GraphicsComponent parent) {
        this.parent = parent;
    }
}

