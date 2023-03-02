package Calculator.Parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Parser<T> {
    protected String regex = null;


    public Map<String, String> split(String s) throws IllegalStateException {
        Map<String, String> elements = new HashMap<>();
        Pattern pattern = Pattern.compile(this.regex);
        Matcher matcher = pattern.matcher(s.replace(" ", ""));
        matcher.find();
        elements.put("first", matcher.group(1));
        elements.put("sign", matcher.group(2));
        elements.put("second", matcher.group(3));
        return elements;
    }
    public abstract T parse(String s) throws IllegalStateException;
}
