import main.Person;
import org.joda.time.LocalDate;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person;

    @Before
    public void init() { person = new Person(1, "Казаков Александр Владимирович", LocalDate.parse("1972-03-02")); }
    @After
    public void tearDown() { person = null; }

    @Test
    public void testid() {
        person.setId(2);
        assertEquals(2, person.getId());
        person.setFio("Казаков Кирилл Александрович");
        assertEquals("Казаков Кирилл Александрович", person.getFio());
        assertEquals(45, person.getAge());
    }
}
