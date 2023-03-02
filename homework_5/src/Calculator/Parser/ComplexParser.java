package Calculator.Parser;

import Calculator.Number.ComplexNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexParser extends Parser<ComplexNumber>{
    public static ComplexParser instance;

    private ComplexParser() {
        this.regex = "\\(+?(.+?)\\)+?([+\\-*:])\\(+?(.+?)\\)+?$+?";
    }
    public static ComplexParser getInstance() {
        if(instance == null)
            return new ComplexParser();

        return instance;
    }
    @Override
    public ComplexNumber parse(String s) {
        Pattern pattern = Pattern.compile("(\\d+?)[+-](\\d+?)+?");
        Pattern signPattern = Pattern.compile("-");
        Matcher matcher = pattern.matcher(s);
        Matcher signMatcher = signPattern.matcher(s);
        matcher.find();
        return ComplexNumber.create(
                Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2))
        ).setNegative( signMatcher.find());
    }
}
