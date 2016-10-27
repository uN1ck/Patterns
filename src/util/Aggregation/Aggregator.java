package util.Aggregation;

import java.util.List;

/**
 * Итерфейс класса-аггрегатора длоя набора какого либо вида объектов
 *
 * @param <T> тип перечисляемых объектов
 */
public interface Aggregator<T> {
    /**
     * Метод создания итератора для текущегно набора
     *
     * @return итератор для текущего набора
     */
    Iterator<T> createIterator();

    /**
     * Метод доступа к коллекции как к List в java
     *
     * @return List объектов
     */
    List getList();

    /**
     * Метод добавления экземпляра к коллекции
     *
     * @param value экземпляр
     */
    void add(T value);

    /**
     * Метод удаления экземпляра из коллекции
     *
     * @param value экземпляр
     */
    void remove(T value);

}
