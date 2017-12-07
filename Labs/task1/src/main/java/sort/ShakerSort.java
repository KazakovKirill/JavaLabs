package sort;

import repositories.Repository;
import java.util.Comparator;

public class ShakerSort<T> implements Sort<T> {
    @Override
    public void sort(Comparator<T> comparator, Repository repository) {
        T[] persons = (T[]) repository.getItems();
        int left = 0, right = repository.getCount() - 1;
        while (left < right) {
            for (int i = left; i < right; i++)
                if (comparator.compare(persons[i], persons[i + 1]) > 0) {
                    T temp = persons[i];
                    persons[i] = persons[i + 1];
                    persons[i + 1] = temp;
                }
            right--;
            for (int i = right; i > left; i--)
                if (comparator.compare(persons[i - 1], persons[i]) > 0) {
                    T temp = persons[i];
                    persons[i] = persons[i - 1];
                    persons[i - 1] = temp;
                }
            left++;
        }
    }
}
