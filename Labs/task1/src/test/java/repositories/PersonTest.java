package repositories;

import entities.Person;
import org.joda.time.LocalDate;
import org.junit.*;
import org.junit.jupiter.api.Assertions;

public class PersonTest {
    private Person person;

    @Before
    public void init() { person = new Person(1, "Казаков Александр Владимирович", LocalDate.parse("1972-03-02")); }
    @After
    public void tearDown() { person = null; }

    @Test
    public void testid() {
        person.setId(2);
        Assertions.assertEquals(2, person.getId());
        person.setFio("Казаков Кирилл Александрович");
        Assertions.assertEquals("Казаков Кирилл Александрович", person.getFio());
        Assertions.assertEquals(45, person.getAge());
    }
}
