package sort;

import main.Person;
import main.Repository;

import java.util.Comparator;

public class InsertionSort implements Sort {
    @Override
    public void sort(Comparator<Person> c, Repository repository) {
        Person[] persons = repository.getPersons();
        Person temp; int j;
        for (int i = 0; i < repository.getCount() - 1; i++) {
            if (c.compare(persons[i], persons[i + 1]) > 0) {
                temp = persons[i + 1];
                persons[i + 1] = persons[i];
                j = i;
                while (j > 0 && c.compare(temp, persons[j - 1]) < 0)
                    persons[j] = persons[j-- - 1];
                persons[j] = temp;
            }
        }
        //repository.setPersons(persons);
    }
}
