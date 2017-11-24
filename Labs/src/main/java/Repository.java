import java.util.Arrays;
import java.util.Comparator;

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
            Person[] temp = Arrays.copyOf(persons, count << 1);
            persons = temp;
        }
        persons[count++] = person;
    }

    public void delete(int index) {
        for (int i = index; i < persons.length - 1; i++)
            persons[i] = persons[i + 1];
        if (--count << 1 == persons.length) {
            Person[] temp = Arrays.copyOf(persons, count >> 1);
            persons = temp;
        }
    }

    public void bubbleSort(Comparator<Person> c) {
        for (int i = 0; i < count; i++)
            for (int j = i + 1; j < count; j++)
                if (c.compare(persons[i], persons[j]) > 0)
                {
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

    public void quickSort(Comparator<Person> c) {
        quickSort(0, count - 1, c);
    }

    private void quickSort(int start, int end, Comparator<Person> c) {
        if (start >= end) return;
        int i = start, j = end, cur = (i + j) / 2;
        while (i < j) {
            while (i < cur && c.compare(persons[i], persons[cur]) > 0) i++;
            while (j > cur && c.compare(persons[cur], persons[j]) > 0) j--;
            if (i < j) {
                Person temp = persons[i];
                persons[i] = persons[j];
                persons[j] = temp;
                if (i == cur) cur = j;
                else if (j == cur) cur = i;
            }
            quickSort(start, cur, c);
            quickSort(cur + 1, end, c);
        }
    }
}