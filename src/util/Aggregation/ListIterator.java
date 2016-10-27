package util.Aggregation;

import java.util.ArrayList;
import java.util.List;

public class ListIterator<T> implements Iterator<T> {
    List<T> aggregatedListLink = null;
    int pos = 0;

    public ListIterator(ArrayList<T> aggregator) {
        aggregatedListLink = aggregator;
    }

    @Override
    public void First() {
        pos = 0;
    }

    @Override
    public boolean Next() {
        if (pos < aggregatedListLink.size()) {
            pos += 1;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean isDone() {
        return pos < aggregatedListLink.size();
    }

    @Override
    public T getItem() {
        return aggregatedListLink.get(pos);
    }
}
