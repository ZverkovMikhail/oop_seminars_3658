package Calculator.Parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Parser<T> {

    public Map<String, String> split(String s) throws IllegalStateException;
    public T parse(String s) throws IllegalStateException;
}
