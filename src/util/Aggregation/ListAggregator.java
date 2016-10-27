package util.Aggregation;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-контейнер являющийся АДАПТЕРОМ класса list
 */
public class ListAggregator<T> implements Aggregator<T> {
    private ArrayList<T> aggregatedList;

    public ListAggregator() {
        aggregatedList = new ArrayList<>();
    }

    @Override
    public Iterator createIterator() {
        return new ListIterator<T>(aggregatedList);
    }

    @Override
    public List getList() {
        return aggregatedList;
    }

    @Override
    public void add(T value) {
        aggregatedList.add(value);
    }

    @Override
    public void remove(T value) {
        aggregatedList.remove(value);
    }

}
