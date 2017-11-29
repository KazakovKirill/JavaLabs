package sort;

import main.Person;
import main.Repository;

import java.util.Comparator;

public class BubbleSort implements Sort {
    @Override
    public void sort(Comparator<Person> c, Repository repository) {
        Person[] persons = repository.getPersons();
        for (int i = 0; i < repository.getCount(); i++)
            for (int j = i + 1; j < repository.getCount(); j++)
                if (c.compare(persons[i], persons[j]) > 0) {
                    Person temp = persons[i];
                    persons[i] = persons[j];
                    persons[j] = temp;
                }
        repository.setPersons(persons);
    }
}
