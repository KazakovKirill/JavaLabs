package sort;

import main.Person;
import main.Repository;

import java.util.Comparator;

public class ShakerSort implements Sort {
    @Override
    public void sort(Comparator<Person> c, Repository repository) {
        Person[] persons = repository.getPersons();
        int left = 0, right = repository.getCount() - 1;
        while (left < right) {
            for (int i = left; i < right; i++)
                if (c.compare(persons[i], persons[i + 1]) > 0) {
                    Person temp = persons[i];
                    persons[i] = persons[i + 1];
                    persons[i + 1] = temp;
                }
            right--;
            for (int i = right; i > left; i--)
                if (c.compare(persons[i - 1], persons[i]) > 0) {
                    Person temp = persons[i];
                    persons[i] = persons[i - 1];
                    persons[i - 1] = temp;
                }
            left++;
        }
        repository.setPersons(persons);
    }
}
