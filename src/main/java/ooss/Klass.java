package ooss;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private final int number;
    private Student leader;
    private final List<Person> attachedPersons = new ArrayList<>();


    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void assignLeader(Student student) {
        if (student.isIn(this)) {
            leader = student;
            for (Person person : attachedPersons) {
                if (person instanceof Teacher) {
                    System.out.println("I am " + person.getName() + ", teacher of Class " + number + ". I know " + student.getName() + " become Leader.");
                } else if (person instanceof Student && person != student) {
                    System.out.println("I am " + person.getName() + ", student of Class " + number + ". I know " + student.getName() + " become Leader.");
                }
            }
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public void attach(Person person) {
        attachedPersons.add(person);
    }

    public boolean isLeader(Student student) {
        return leader != null && leader.equals(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Klass klass = (Klass) o;

        return number == klass.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
