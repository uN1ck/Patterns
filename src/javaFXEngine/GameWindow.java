package javaFXEngine;

import javafx.scene.canvas.GraphicsContext;

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
    public void addChild(GraphicsComponent child) {

    }

    @Override
    public List getChildren() {
        return null;
    }

    @Override
    public void drawSelf(GraphicsContext gc) {

    }
}
