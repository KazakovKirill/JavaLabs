package sort;
import repositories.Repository;

import java.util.Comparator;

public interface Sort<T> {
    void sort(Comparator<T> comparator, Repository repository);
}
