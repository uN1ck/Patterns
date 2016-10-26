package javaFXEngine;

import actionObject.ActionObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.List;

public class DrawableActionObject extends GraphicsComponent {
    Image tile;
    ActionObject owner;

    /**
     * Конструктор композита
     *
     * @param x      координата по x
     * @param y      координата по y
     * @param z      порядок отрисовки, определяющйи какой объект выше
     * @param width  ширина объекта
     * @param height высота объекта
     */
    public DrawableActionObject(int x, int y, int z, int width, int height, ActionObject owner) {
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
        gc.drawImage(tile, x, y);
    }
}
