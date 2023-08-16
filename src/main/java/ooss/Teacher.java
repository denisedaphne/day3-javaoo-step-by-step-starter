package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private final List<Klass> taughtClasses = new ArrayList<>();
    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public void assignTo(Klass klass) {
        if (!belongsTo(klass)) {
            taughtClasses.add(klass);
        }
    }

    public boolean belongsTo(Klass klass) {
        return taughtClasses.contains(klass);
    }

    public boolean isTeaching(Student student) {
        return taughtClasses.stream()
                .anyMatch(student::isIn);
    }

    @Override
    public String introduce() {
        String introduction = super.introduce() + " I am a teacher.";
        if (!taughtClasses.isEmpty()) {
            String classNumbers = taughtClasses.stream()
                    .map(Klass::getNumber)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            return introduction + " I teach Class " + classNumbers + ".";
        } else{
            return introduction;
        }
    }
}
