import java.time.LocalDate;

/**
 * <h3>Task 1</h3>
 * Реализовать, с учетом ооп подхода, приложение Для проведения исследований с генеалогическим древом.
 * Идея: описать некоторое количество компонент, например: модель человека компонента хранения связей и
 * отношений между людьми: родитель, ребёнок - классика, но можно подумать и про отношение, брат, свекровь,
 * сестра и т. д. компонент для проведения исследований дополнительные компоненты, например отвечающие за
 * вывод данных в консоль, загрузку и сохранения в файл, получение\построение отдельных моделей человека
 * Под “проведением исследования” можно понимать получение всех детей выбранного человека.<br><br>
 * <p>
 * Используйте предыдущие задачи из прошлого домашнего задания. Необходимо гарантированно продумать иерархию
 * компонент и взаимодействия их между собой.
 * Обеспечить переход от использования явных классов в сторону использования абстрактных типов. Т е работаем не с:
 * конкретным экземпляром генеалогического древа, а с интерфейсом “ генеалогическое древо”
 */
public class Main {
    public static void main(String[] args) {
        People john = new FamilyMember(
                0,
                "John",
                "Jonson",
                People.Sex.male,
                LocalDate.of(1949, 1, 14)
        );
        People dufna = new FamilyMember(
                1,
                "Dufna",
                "Jonson",
                People.Sex.female,
                LocalDate.of(1953, 3, 16)
        );
        People alexandr = new FamilyMember(
                2,
                "Alexandr",
                "Jonson",
                People.Sex.male,
                LocalDate.of(1986, 10, 26)
        );
        People judy = new FamilyMember(
                3,
                "Judy",
                "Jonson",
                People.Sex.female,
                LocalDate.of(1990, 11, 6)
        );
        People tomas = new FamilyMember(
                4,
                "Tomas",
                "Jonson",
                People.Sex.male,
                LocalDate.of(1999, 4, 21)
        );

        GeoTree geoTree = new MyGeoTree()
                .appendChild(john, alexandr).appendChild(john, judy).appendChild(john, tomas)
                .appendChild(dufna, alexandr).appendChild(dufna, judy).appendChild(dufna, tomas)
                .appendMarried(dufna, john);


        FileTransfer fileTransfer = new FileTransfer("geotree.json");
        fileTransfer.write(GeoTreeParser.dump(geoTree));

        geoTree = GeoTreeParser.load(fileTransfer.read());

        System.out.println(new MyResearch(geoTree).spend(john, Relationship.child));
        System.out.println(new MyResearch(geoTree).complexSpend(john));
        System.out.println(new MyResearch(geoTree).complexSpend(tomas));

        System.out.println(
                geoTree.find(PeopleFilter.create()
                        .setLastName("Jonson")
                        .setStartDate(LocalDate.of(1990,1,1))
                        .setSex(People.Sex.female)
                )
        );
    }
}