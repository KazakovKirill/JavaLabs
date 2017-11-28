import java.util.Comparator;

public class InsertionSort implements Sort {
    @Override
    public void sort(Comparator<Person> c, Person[] persons, int count) {
        Person temp; int j;
        for (int i = 0; i < count - 1; i++) {
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
}
