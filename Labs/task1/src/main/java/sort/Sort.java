package sort;

import main.Person;
import java.util.Comparator;

public interface Sort {
    void sort(Comparator<Person> c, Person[] persons, int count);
}
