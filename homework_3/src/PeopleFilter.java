import java.time.LocalDate;

public class PeopleFilter implements Filter<People> {
    private String firstName;
    private String lastName;
    private People.Sex sex;
    private LocalDate startDate;
    private LocalDate endDate;

    private PeopleFilter() {
        this.firstName = null;
        this.lastName = null;
        this.sex = null;
        this.startDate = null;
        this.endDate = null;
    }

    public static PeopleFilter create() {
        return new PeopleFilter();
    }

    @Override
    public boolean check(People p) {
        if (this.firstName != null && !p.firstName().equalsIgnoreCase(firstName))
            return false;
        if (this.lastName != null && !p.lastName().equalsIgnoreCase(lastName))
            return false;
        if (this.sex != null && p.sex() != this.sex)
            return false;
        if (this.startDate != null && p.birthday().isBefore(this.startDate))
            return false;
        if (this.endDate != null && p.birthday().isAfter(this.endDate))
            return false;
        return true;
    }

    public PeopleFilter setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PeopleFilter setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PeopleFilter setSex(People.Sex sex) {
        this.sex = sex;
        return this;
    }

    public PeopleFilter setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public PeopleFilter setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }
}

