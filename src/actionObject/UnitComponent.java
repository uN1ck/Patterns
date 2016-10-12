package actionObject;


import java.util.List;

/**
 * Интерфейс компоновщика объектаДействия
 */
public interface UnitComponent {

    /**
     * Метод доступа к предку
     *
     * @return Предок объектаДействия
     */
    UnitComponent getOwnership();

    /**
     * Метод установки предка объекта действия
     *
     * @param component Предок объектаДействия
     */
    void setOwnership(UnitComponent component);

    /**
     * Метод доступа к детям объектаДействия
     *
     * @return дети объектаДействия
     */
    List<UnitComponent> getChildren();

    /**
     * Метод добавления детей к объектуДействия
     *
     * @param component объектДействия
     */
    void addChild(UnitComponent component);
}
