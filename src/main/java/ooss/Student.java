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
        String introduction = super.introduce() + " I am a student.";

        return klass != null ? klass.isLeader(this)
                ? introduction + " I am the leader of class " + klass.getNumber() + "."
                : introduction + " I am in class " + klass.getNumber() + "."
                : introduction;
    }
}
