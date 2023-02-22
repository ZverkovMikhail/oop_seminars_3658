import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class JsonParser<T> implements Parser<T>{
    public List<Map<String, String>> parse(String jsonString, String key) {
        List<Map<String, String>> ret = new ArrayList<>();
        Map<String, String> temp;
        Pattern blockPattern = Pattern.compile(String.format("\"%s\":\\[(.+?)\\]", key));
        Pattern objectPattern = Pattern.compile("\\{(.+?)\\}");
        Pattern fieldPattern = Pattern.compile("\"(.+?)\":\"(.+?)\"+");
        Matcher blockMatcher = blockPattern.matcher(jsonString.replace(" ", ""));
        if(blockMatcher.find()) {
            Matcher objectMatcher = objectPattern.matcher(blockMatcher.group(1));
            Matcher fieldMatcher;
            while (objectMatcher.find()) {
                fieldMatcher = fieldPattern.matcher(objectMatcher.group(1));
                temp = new HashMap<>();

                while (fieldMatcher.find()) {
                    temp.put(fieldMatcher.group(1), fieldMatcher.group(2));
                }
                ret.add(temp);
            }
        }
        return ret;
    }
}
