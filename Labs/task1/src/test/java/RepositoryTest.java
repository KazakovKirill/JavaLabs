import org.joda.time.LocalDate;
import org.junit.*;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {
    private Repository repository;
    private Person one, two, three, four, five, six, seven, eight, nine;

    @Before
    public void init() {
        repository = new Repository();
        one = new Person(1, "Буханов Василий Владимирович", LocalDate.parse("1997-05-06"));
        repository.add(one);
        two =  new Person(2, "Иванов Андрей Владимирович", LocalDate.parse("1982-08-05"));
        repository.add(two);
        three = new Person(3, "Попова Наталия Юрьевна", LocalDate.parse("1995-04-07"));
        repository.add(three);
        four = new Person(4, "Кукушкин Сергей Евгеньевич", LocalDate.parse("1972-07-19"));
        repository.add(four);
        five = new Person(5, "Власов Сергей Васильевич", LocalDate.parse("1966-09-27"));
        repository.add(five);
        six = new Person(6, "Теплинских Елена Сергеевна", LocalDate.parse("1979-03-01"));
        repository.add(six);
        seven = new Person(7, "Кротов Алексей Юрьевич", LocalDate.parse("1984-10-06"));
        repository.add(seven);
        eight = new Person(8, "Кайков Андрей Альбертович", LocalDate.parse("1971-12-25"));
        repository.add(eight);
        nine = new Person(9, "Конусов Павел Иванович", LocalDate.parse("1975-04-10"));
        repository.add(nine);
    }

    @After
    public void tearDown() {
        repository = null;
    }

    @Test
    public void testAddDelete() {
        //for (int i = 0; i < 5; i++)
        repository.delete(4);
        for (Person p : repository.getPersons())
            System.out.println(p.toString());
        //assertArrayEquals(new Person[] { one, two, three, four }, repository.getPersons());
        //repository.add(eight);
        //assertArrayEquals(new Person[] { one, two, three, four, eight }, repository.getPersons());
    }

    @Test
    public void testBubbleSort() {
        repository.bubbleSort((a, b) -> a.getFio().length() - b.getFio().length());
        Person[] persons = { three, seven, nine, five, eight, four, two, six, one };
        assertArrayEquals(persons, repository.getPersons());
    }

    @Test
    public void testShakerSort() {
        repository.shakerSort((a, b) -> b.getAge() - a.getAge());
        Person[] persons = { five, four, eight, nine, six, two, seven, three, one };
        assertArrayEquals(persons, repository.getPersons());
    }

    @Test
    public void testInsertionSort() {
        repository.insertionSort((a, b) -> Math.abs(a.getAge() - 30) - Math.abs(b.getAge() - 30));
        Person[] persons = { seven, two, three, six, one, nine, four, eight, five };
        assertArrayEquals(persons, repository.getPersons());
    }

    @Test
    public void testFindAll() {
        Repository result = repository.findAll(p -> p != null && p.getAge() < 30);
        Person[] persons = { one, three };
        assertArrayEquals(persons, result.getPersons());
    }
}
