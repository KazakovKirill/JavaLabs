package main;

import sort.Sort;

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

    public void setPersons(Person[] persons) {
        this.persons = persons;
    }

    public int getCount() {
        return count;
    }

    public void add(Person person) {
        if (count == persons.length)
            persons = Arrays.copyOf(persons, count << 1);
        persons[count++] = person;
    }

    public void remove(int index) {
        for (int i = index; i < count - 1; i++)
            persons[i] = persons[i + 1];
        persons[--count] = null;
        if (count << 2 == persons.length)
            persons = Arrays.copyOf(persons, count << 1);
    }

    public void sort(Sort s, Comparator<Person> c) {
        s.sort(c, this);
    }

    public Repository findAllByFio(String fio) {
        return findAll(p -> p.getFio().compareTo(fio) == 0);
    }

    public Repository findAllByAge(int age) {
        return findAll(p -> p.getAge() == age);
    }

    public Repository findAll(Predicate<Person> pred) {
        Repository result = new Repository();
        for (Person p : persons)
            if (p != null && pred.test(p))
                result.add(p);
        return result;
    }
}