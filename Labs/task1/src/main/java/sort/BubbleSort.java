package sort;

import main.Person;
import java.util.Comparator;

public class BubbleSort implements Sort {
    @Override
    public void sort(Comparator<Person> c, Person[] persons, int count) {
        for (int i = 0; i < count; i++)
            for (int j = i + 1; j < count; j++)
                if (c.compare(persons[i], persons[j]) > 0) {
                    Person temp = persons[i];
                    persons[i] = persons[j];
                    persons[j] = temp;
                }
    }
}
