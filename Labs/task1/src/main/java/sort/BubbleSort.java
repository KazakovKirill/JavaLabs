package sort;

import repositories.Repository;

import java.util.Comparator;

public class BubbleSort<T> implements Sort<T> {
    @Override
    public void sort(Comparator<T> comparator, Repository repository) {
        T[] items = (T[]) repository.getItems();
        for (int i = 0; i < repository.getCount(); i++)
            for (int j = i + 1; j < repository.getCount(); j++)
                if (comparator.compare(items[i], items[j]) > 0) {
                    T temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
    }
}
