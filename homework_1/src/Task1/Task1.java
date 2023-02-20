package Task1;

import java.time.LocalDate;

/**
 * Реализовать, с учетом ооп подхода, приложение Для проведения исследований с генеалогическим древом.
 * Идея: описать некоторое количество компонент, например: модель человека компонента хранения связей и
 * отношений между людьми: родитель, ребёнок - классика, но можно подумать и про отношение, брат, свекровь,
 * сестра и т. д. компонент для проведения исследований дополнительные компоненты, например отвечающие за
 * вывод данных в консоль, загрузку и сохранения в файл, получение\построение отдельных моделей человека
 * Под “проведением исследования” можно понимать получение всех детей выбранного человека.
 */
public class Task1 {
    public static void run() {
        FamilyMember john = new FamilyMember(
                "John",
                "Jonson",
                FamilyMember.Sex.male,
                LocalDate.of(1949, 1, 14)
        ); FamilyMember dufna = new FamilyMember(
                "Dufna",
                "Jonson",
                FamilyMember.Sex.female,
                LocalDate.of(1953, 3, 16)
        ); FamilyMember alexandr = new FamilyMember(
                "Alexandr",
                "Jonson",
                FamilyMember.Sex.male,
                LocalDate.of(1986, 10, 26)
        ); FamilyMember judy = new FamilyMember(
                "Judy",
                "Jonson",
                FamilyMember.Sex.female,
                LocalDate.of(1990, 11, 6)
        ); FamilyMember tomas = new FamilyMember(
                "Tomas",
                "Jonson",
                FamilyMember.Sex.male,
                LocalDate.of(1999, 4, 21)
        );

        GeoTree geoTree = new GeoTree()
                .appendChild(john, alexandr).appendChild(john, judy).appendChild(john, tomas)
                .appendChild(dufna, alexandr).appendChild(dufna, judy).appendChild(dufna, tomas)
                .appendMarried(dufna, john);

        System.out.println(geoTree);
        System.out.println(new Research(geoTree).spend(john, Relationship.child));
        System.out.println(new Research(geoTree).complexSpend(john));
        System.out.println(new Research(geoTree).complexSpend(tomas));
    }
}