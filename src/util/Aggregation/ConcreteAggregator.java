package util.Aggregation;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-контейнер для действий активного объекта
 */
public class ConcreteAggregator<T> implements Aggregator<T> {
    private ArrayList<T> aggregatedList;

    public ConcreteAggregator() {
        aggregatedList = new ArrayList<>();
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator<T>(aggregatedList);
    }

    @Override
    public List<T> getNormalArray() {
        return aggregatedList;
    }
}
