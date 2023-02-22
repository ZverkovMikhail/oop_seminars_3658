import java.time.LocalDateTime;

/**
 * С учетом информации полученной ранее знакомимся с параметрическим полиморфизмом и продолжаем погружаться в ООП.
 * Спроектировать и реализовать планировщик дел для работы с задачами разных приоритетов.
 * <p>
 * Например:
 * определить уровень приоритетов: низкий, средний, немедленное выполнение
 * выделить компоненту для хранения данных
 * выделить компоненту для организации импорта\экспорта данных
 * Файл должен содержать следующие данные: id, дату добавления записи, время добавления записи, дедлай задачи, ФИО автора,
 * данные хранятся в файле csv/jsom/xml
 * другие компоненты
 */
public class Main {
    public static void main(String[] args) {

        TaskRepository<String> tr = new TaskRepository<>();
//        tr.add(tr.createElement(0)
//                .setBody("Task1")
//                .setAddedTime(LocalDateTime.of(2023, 1, 24, 18, 0))
//                .setDeadline(LocalDateTime.of(2023, 2, 23, 19, 0))
//                .setAuthorName("Петрович"));
//
//        tr.add(tr.createElement(1)
//                .setBody("Task2")
//                .setAddedTime(LocalDateTime.of(2022, 1, 24, 18, 0))
//                .setDeadline(LocalDateTime.of(2023, 3, 6, 18, 0))
//                .setAuthorName("Семеныч"));
//        tr.add(tr.createElement(2)
//                .setBody("Task3")
//                .setAddedTime(LocalDateTime.of(2021, 1, 24, 18, 0))
//                .setDeadline(LocalDateTime.of(2023, 3, 1, 18, 0))
//                .setAuthorName("Петрович"));
//        tr.add(tr.createElement(3)
//                .setBody("Task4")
//                .setAddedTime(LocalDateTime.of(2021, 1, 24, 18, 0))
//                .setDeadline(LocalDateTime.of(2023, 4, 24, 18, 0))
//                .setAuthorName("Иванов"));
//
        PriorityChecker checker = PriorityChecker.create()
                .appendProperty(Priority.LOW, 60)
                .appendProperty(Priority.MEDIUM, 30)
                .appendProperty(Priority.HIGH, 10)
                .appendProperty(Priority.IMMEDIATE, 1);

        TaskPlanner<String> tp = new TaskPlanner<>(tr, checker);

//        tr.saveToJson("tasks.json");

        tr.loadFromJson("tasks.json");

        System.out.println(tp.getTasksByPriority(Priority.LOW));
        System.out.println(tp.getTasksByPriority(Priority.MEDIUM));
        System.out.println(tp.getTasksByPriority(Priority.HIGH));
        System.out.println(tp.getTasksByPriority(Priority.IMMEDIATE));
        System.out.println(tp.getPlane());
    }

}