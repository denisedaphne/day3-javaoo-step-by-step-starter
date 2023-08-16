package ooss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private final List<Klass> taughtClasses = new ArrayList<>();
    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public void assignTo(Klass klass) {
        if (!taughtClasses.contains(klass)) {
            taughtClasses.add(klass);
        }
    }

    public boolean belongsTo(Klass klass) {
        return taughtClasses.contains(klass);
    }

    public boolean isTeaching(Student student) {
        for (Klass klass : taughtClasses) {
            if (student.isIn(klass)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String introduce() {
        if (!taughtClasses.isEmpty()) {
            String classNumbers = taughtClasses.stream()
                    .map(Klass::getNumber)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            return super.introduce() + " I am a teacher. I teach Class " + classNumbers + ".";
        } else{
            return super.introduce() + " I am a teacher.";
        }
    }
}
