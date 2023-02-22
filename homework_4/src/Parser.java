import java.util.List;
import java.util.Map;

public interface Parser<T> {
    public List<Map<String, String>> parse(String jsonString, String key);
    public String dump(List<T> elements);
    public List<T> load(String jsonString);
}
