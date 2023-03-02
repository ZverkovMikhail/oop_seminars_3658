package Calculator.Parser;

import Calculator.Number.RationalNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RationalParser extends Parser<RationalNumber>{
    public static RationalParser instance;

    private RationalParser() {
        this.regex = "(.+?)([+\\-*:])(.+?)$+?";
    }
    public static RationalParser getInstance() {
        if(instance == null)
            return new RationalParser();

        return instance;
    }

    @Override
    public RationalNumber parse(String s) {
        Pattern pattern = Pattern.compile("(\\d+?)/(\\d+?)+?");
        Pattern signPattern = Pattern.compile("-");
        Matcher matcher = pattern.matcher(s);
        Matcher signMatcher = signPattern.matcher(s);
        matcher.find();
        return RationalNumber.create(
                Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2))
        ).setNegative( signMatcher.find());
    }
}
