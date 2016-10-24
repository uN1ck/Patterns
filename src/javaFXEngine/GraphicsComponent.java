package javaFXEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактный класс-композит для всех графических элементов игры
 */
public abstract class GraphicsComponent {
    public int x;
    public int y;
    public int z;
    ArrayList<GraphicsComponent> children;

    /**
     * Конструктор композита
     *
     * @param x координата по x
     * @param y координата по y
     * @param z порядок отрисовки, определяющйи какой объект выше
     */
    public GraphicsComponent(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        children = new ArrayList<>();
    }

    public List<GraphicsComponent> getChildren() {
        return children;
    }

    public abstract void drawSelf();
}

