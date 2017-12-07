package repositories;

import sort.Sort;

import java.util.Arrays;
import java.util.Comparator;

public abstract class AbstractRepository<T> implements Repository<T> {
    protected T[] items;
    protected int count;
    protected Sort sorter;

    void setSorter(Sort sorter){
        this.sorter = sorter;
    }

    public int getCount() {
        return count;
    }

    public T[] getItems() {
        return items = Arrays.copyOf(items, count);
    }

    public void add(T item) {
        if (count == items.length)
            items = Arrays.copyOf(items, count << 1);
        items[count++] = item;
    }

    public void remove(int index) {
        for (int i = index; i < count - 1; i++)
            items[i] = items[i + 1];
        items[--count] = null;
        if (count << 2 == items.length)
            items = Arrays.copyOf(items, count << 1);
    }

    public void sort(Comparator<T> c) {
        sorter.sort(c, this);
    }
}
