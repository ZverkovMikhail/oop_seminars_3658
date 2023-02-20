import java.time.LocalDate;

public class FamilyMember extends People{
    public FamilyMember(String firstName, String lastName, Sex sex, LocalDate birthday) {
        super(firstName, lastName, sex, birthday);
    }
}
