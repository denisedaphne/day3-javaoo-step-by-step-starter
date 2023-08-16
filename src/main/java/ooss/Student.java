package ooss;

public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public void join(Klass klass) {
        this.klass = klass;
    }

    public boolean isIn(Klass klass) {
        return this.klass != null && this.klass.equals(klass);
    }

    @Override
    public String introduce() {
        if (klass != null) {
            return super.introduce() + " I am a student. I am in class " + klass.getNumber() + ".";
        }
        return super.introduce() + " I am a student.";
    }
}
