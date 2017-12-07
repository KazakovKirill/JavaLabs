package repositories;

import entities.Configurator;
import entities.Person;

import java.util.function.Predicate;

public class PersonRepository extends AbstractRepository<Person> {
    public PersonRepository() {
        items = new Person[8];
        sorter = Configurator.getSort();
        count = 0;
    }

    public PersonRepository findAllByFio(String fio) {
        return findAll(p -> p.getFio().compareTo(fio) == 0);
    }

    public PersonRepository findAllByAge(int age) {
        return findAll(p -> p.getAge() == age);
    }

    public PersonRepository findAll(Predicate<Person> pred) {
        PersonRepository result = new PersonRepository();
        for (Person item : items)
            if (item != null && pred.test(item))
                result.add(item);
        return result;
    }
}
