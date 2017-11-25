import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Repository {
    private Person[] persons;
    private int count;

    public Repository() {
        persons = new Person[8];
        count = 0;
    }

    public Person[] getPersons() {
        return Arrays.copyOf(persons, count);
    }

    public int getCount() {
        return count;
    }

    public void add(Person person) {
        if (count == persons.length) {
            persons = Arrays.copyOf(persons, count << 1);
        }
        persons[count++] = person;
    }

    public void delete(int index) {
        for (int i = index; i < count - 1; i++)
            persons[i] = persons[i + 1];
        if (--count << 1 == persons.length)
            persons = Arrays.copyOf(persons, count >> 1);
    }

    public void bubbleSort(Comparator<Person> c) {
        for (int i = 0; i < count; i++)
            for (int j = i + 1; j < count; j++)
                if (c.compare(persons[i], persons[j]) > 0) {
                    Person temp = persons[i];
                    persons[i] = persons[j];
                    persons[j] = temp;
                }
    }

    public void shakerSort(Comparator<Person> c) {
        int left = 0, right = count - 1;
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
    }

    public void insertionSort(Comparator<Person> c) {
        Person temp; int j;
        for(int i = 0; i < count - 1; i++){
            if (c.compare(persons[i], persons[i + 1]) > 0) {
                temp = persons[i + 1];
                persons[i + 1] = persons[i];
                j = i;
                while (j > 0 && c.compare(temp, persons[j - 1]) < 0)
                    persons[j] = persons[j-- - 1];
                persons[j] = temp;
            }
        }
    }

    public Repository findAll(Predicate<Person> pred) {
        Repository result = new Repository();
        for (Person p : persons)
            if (pred.test(p))
                result.add(p);
        return result;
    }
}
