import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TaskJsonParser<T> extends JsonParser<Task<T>> {
    @Override
    public String dump(List<Task<T>> elements) {
        StringBuilder json = new StringBuilder();
        json.append("{\"tasks\":[");
        Task<T> tempP;
        T tempN;
        for (int i = 0; i < elements.size(); i++) {
            if (i > 0)
                json.append(",");
            tempP = elements.get(i);
            json.append(String.format(
                    "{\"id\":\"%d\", \"body\":\"%s\", \"deadline\":\"%s\", \"added_time\":\"%s\", \"author_name\":\"%s\"}",
                    tempP.id(), tempP.body(), tempP.deadlineData(), tempP.addedTime(), tempP.authorName()));
        }
        json.append("]}");
        return json.toString();
    }

    @Override
    public List<Task<T>> load(String jsonString) {
        List<Map<String, String>> tasksField = parse(jsonString, "tasks");
        List<Task<T>> tasks = new ArrayList<>();

        for (Map<String, String> field : tasksField) {
            int[] deadline = Arrays.stream(field.get("deadline").split("[-T:]"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] addedTime = Arrays.stream(field.get("added_time").split("[-T:]"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            tasks.add(new Task<T>(Integer.parseInt(field.get("id")))
                    .setBody((T)field.get("body"))
                    .setDeadline(LocalDateTime.of(deadline[0], deadline[1], deadline[2], deadline[3], deadline[4]))
                    .setAddedTime(LocalDateTime.of(addedTime[0], addedTime[1], addedTime[2], addedTime[3], addedTime[4]))
                    .setAuthorName(field.get("author_name"))
            );
        }
//
        return tasks;
    }
}
