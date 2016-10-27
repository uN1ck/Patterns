package javaFXEngine;

import actionObject.ActionObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.ArcType;
import util.Aggregation.Iterator;

import java.util.List;

/**
 * Класс определяющий отрисовываемый единичный объект действия.
 * Является спрайтовым отображением объекта с карты
 */
public class DrawableActionObject extends GraphicsComponent {
    Image tile;
    ActionObject ownerLink = null;

    /**
     * Конструктор композита
     *
     * @param x      координата по x
     * @param y      координата по y
     * @param z      порядок отрисовки, определяющйи какой объект выше
     * @param width  ширина объекта
     * @param height высота объекта
     */
    public DrawableActionObject(int x, int y, int z, int width, int height, Image image, ActionObject value) {
        super(x, y, z, width, height);
        this.tile = image;
        this.ownerLink = value;
    }

    /**
     * Метод отрисовки спрайта активного объекта и информации о его здоровье
     *
     * @param gc контекст отрисовки
     */
    @Override
    public void drawSelf(GraphicsContext gc) {
        gc.drawImage(tile, x, y);
        gc.fillArc(x + width / 2, y + height / 2, width / 2, height / 2, 0, 180, ArcType.OPEN);
        double hm = Integer.parseInt(ownerLink.getProperty("HealthMaximal"));
        double hc = Integer.parseInt(ownerLink.getProperty("Health"));
        gc.fillArc(x + width / 2, y + height / 2, width / 2, height / 2, 0, hc / hm * 180, ArcType.OPEN);
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
