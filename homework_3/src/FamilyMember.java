import java.time.LocalDate;

public class FamilyMember extends People{
    public FamilyMember(int id, String firstName, String lastName, Sex sex, LocalDate birthday) {
        super(id, firstName, lastName, sex, birthday);
    }

    @Override
    public int compareTo(People o) {
        if (this.id() == o.id()){
            return 0;
        }else if (this.id() < o.id()){
            return -1;
        }
        return 1;
    }
}
