package javaFXEngine;

import javafx.scene.canvas.GraphicsContext;
import util.Aggregation.Iterator;

import java.util.List;

/**
 * Класс окна игры, концентрирует на себе все отрисовываемые элементы игры.
 * гененрирует карту спрайтов игры
 */
public class GameWindow extends GraphicsComponent {

    /**
     * Конструктор композита
     *
     * @param x      координата по x
     * @param y      координата по y
     * @param z      порядок отрисовки, определяющйи какой объект выше
     * @param width  ширина объекта
     * @param height высота объекта
     */
    public GameWindow(int x, int y, int z, int width, int height) {
        super(x, y, z, width, height);
    }

    @Override
    public void drawSelf(GraphicsContext gc) {

    }

    @Override
    public Iterator<GraphicsComponent> createIterator() {
        return null;
    }

    @Override
    public List getList() {
        return null;
    }

    @Override
    public void add(GraphicsComponent value) {

    }

    @Override
    public void remove(GraphicsComponent value) {

    }
}
