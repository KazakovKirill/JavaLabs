package sort;

import repositories.Repository;

import java.util.Comparator;

public class InsertionSort<T> implements Sort<T> {
    @Override
    public void sort(Comparator<T> comparator, Repository repository) {
        T[] items = (T[]) repository.getItems();
        T temp; int j;
        for (int i = 0; i < repository.getCount() - 1; i++) {
            if (comparator.compare(items[i], items[i + 1]) > 0) {
                temp = items[i + 1];
                items[i + 1] = items[i];
                j = i;
                while (j > 0 && comparator.compare(temp, items[j - 1]) < 0)
                    items[j] = items[j-- - 1];
                items[j] = temp;
            }
        }
    }
}
