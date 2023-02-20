package Task1;

import java.time.LocalDate;

public class FamilyMember {
    enum Sex {
        male,
        female

    }

    public FamilyMember(String firstName, String lastName, Sex sex, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthday = birthday;
    }

    private String firstName;
    private String lastName;
    private Sex sex;
    private LocalDate birthday;

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
