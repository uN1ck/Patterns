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
    public T next() {
        if (aggregatedListLink.size() >= pos)
            return null;
        else
            return aggregatedListLink.get(pos++);
    }

    @Override
    public void restart() {
        pos = 0;
    }

}
