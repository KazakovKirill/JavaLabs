package repositories;

import java.util.Comparator;
import java.util.function.Predicate;

public interface Repository<T> {
    T[] getItems();
    int getCount();
    void add(T item);
    void remove(int index);
    void sort(Comparator<T> c);
    Repository<T> findAll(Predicate<T> pred);
}
