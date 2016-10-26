package util.Aggregation;

import java.util.ArrayList;
import java.util.List;

public class ConcreteIterator<T> implements Iterator<T> {
    List<T> aggregatedListLink = null;
    int pos = 0;

    public ConcreteIterator(ArrayList<T> aggregator) {
        aggregatedListLink = aggregator;
    }

    @Override
    public void next() {
        pos++;
    }

    @Override
    public T getValue() {
        return null;
    }
}
