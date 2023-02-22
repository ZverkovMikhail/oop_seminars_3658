import java.time.LocalDate;

public abstract class People implements Comparable<People>{
    enum Sex {
        male,
        female

    }
    private int id;
    private String firstName;
    private String lastName;
    private Sex sex;
    private LocalDate birthday;

    public People(int id, String firstName, String lastName, Sex sex, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthday = birthday;
    }

    public int id() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public Sex sex() {
        return sex;
    }

    public LocalDate birthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s) %s", firstName, lastName, birthday, sex);
    }
}
