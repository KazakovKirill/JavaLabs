package sort;

import main.Person;
import main.Repository;

import java.util.Comparator;

public interface Sort {
    void sort(Comparator<Person> c, Repository repository);
}
