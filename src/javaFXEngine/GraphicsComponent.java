package javaFXEngine;

import javafx.scene.canvas.GraphicsContext;

import java.util.List;

/**
 * Абстрактный класс-композит для всех графических элементов игры
 */
public abstract class GraphicsComponent {
    public int x;
    public int y;
    public int z;
    public int width;
    public int height;

    /**
     * Конструктор композита
     *
     * @param x координата по x
     * @param y координата по y
     * @param z порядок отрисовки, определяющйи какой объект выше
     * @param width ширина объекта
     * @param height высота объекта
     */
    public GraphicsComponent(int x, int y, int z, int width, int height) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
    }

    /**
     * Метод добавления потомков класса
     * @param child добавляемый элемент
     */
    public abstract void addChild(GraphicsComponent child);

    /**
     * Метод доступа к потмокам класса
     * @return
     */
    public abstract List getChildren();

    /**
     * Метод отрисовки текущего экземпляра
     */
    public abstract void drawSelf(GraphicsContext gc);
}

