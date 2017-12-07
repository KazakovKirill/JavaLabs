package entities;

import org.joda.time.LocalDate;

public class Person {
    private int id;
    private String fio;
    private LocalDate birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - birthday.getYear();
        if (today.getDayOfYear() < birthday.getDayOfYear()) age--;
        return age;
    }

    public Person(int id, String fio, LocalDate birthday) {
        setId(id);
        setFio(fio);
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "entities.Person{" + "id=" + id + ", fio='" + fio + '\'' + ", birthday=" + birthday + '}';
    }
}
