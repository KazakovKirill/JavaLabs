package repositories;

import entities.Person;
import org.joda.time.LocalDate;
import org.junit.*;
import sort.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PersonRepositoryTest {
    private PersonRepository personRepository;
    private Person one, two, three, four, five, six, seven, eight, nine;

    @Before
    public void init() {
        personRepository = new PersonRepository();
        one = new Person(1, "Буханов Василий Владимирович", LocalDate.parse("1997-05-06"));
        personRepository.add(one);
        two =  new Person(2, "Иванов Андрей Владимирович", LocalDate.parse("1982-08-05"));
        personRepository.add(two);
        three = new Person(3, "Попова Наталия Юрьевна", LocalDate.parse("1995-04-07"));
        personRepository.add(three);
        four = new Person(4, "Кукушкин Сергей Евгеньевич", LocalDate.parse("1972-07-19"));
        personRepository.add(four);
        five = new Person(5, "Власов Сергей Васильевич", LocalDate.parse("1966-09-27"));
        personRepository.add(five);
        six = new Person(6, "Теплинских Елена Сергеевна", LocalDate.parse("1979-03-01"));
        personRepository.add(six);
        seven = new Person(7, "Кротов Алексей Юрьевич", LocalDate.parse("1984-10-06"));
        personRepository.add(seven);
        eight = new Person(8, "Кайков Андрей Альбертович", LocalDate.parse("1971-12-25"));
        personRepository.add(eight);
        nine = new Person(9, "Конусов Павел Иванович", LocalDate.parse("1975-04-10"));
        personRepository.add(nine);
    }

    @After
    public void tearDown() {
        personRepository = null;
    }

    @Test
    public void testAddDelete() {
        for (int i = 0; i < 5; i++)
            personRepository.remove(4);
        assertArrayEquals(new Person[] { one, two, three, four }, personRepository.getItems());
        personRepository.add(eight);
        assertArrayEquals(new Person[] { one, two, three, four, eight }, personRepository.getItems());
    }

    @Test
    public void testBubbleSort() {
        personRepository.setSorter(new BubbleSort());
        personRepository.sort((a, b) -> a.getFio().length() - b.getFio().length());
        Person[] persons = { three, seven, nine, five, eight, four, two, six, one };
        assertArrayEquals(persons, personRepository.getItems());
    }

    @Test
    public void testShakerSort() {
        personRepository.setSorter(new ShakerSort());
        personRepository.sort((a, b) -> b.getAge() - a.getAge());
        Person[] persons = { five, four, eight, nine, six, two, seven, three, one };
        assertArrayEquals(persons, personRepository.getItems());
    }

    @Test
    public void testInsertionSort() {
        personRepository.setSorter(new InsertionSort());
        personRepository.sort((a, b) -> Math.abs(a.getAge() - 30) - Math.abs(b.getAge() - 30));
        Person[] persons = { seven, two, three, six, one, nine, four, eight, five };
        assertArrayEquals(persons, personRepository.getItems());
    }

    @Test
    public void testFindAll() {
        Repository result = personRepository.findAll(p -> p.getAge() < 30);
        Person[] persons = { one, three };
        assertArrayEquals(persons, result.getItems());
    }

    @Test
    public void testFindAllByFio() {
        Repository result = personRepository.findAllByFio("Попова Наталия Юрьевна");
        Person[] persons = { three };
        assertArrayEquals(persons, result.getItems());
    }

    @Test
    public void testFindAllByAge() {
        Repository result = personRepository.findAllByAge(45);
        Person[] persons = { four, eight };
        assertArrayEquals(persons, result.getItems());
    }
}
