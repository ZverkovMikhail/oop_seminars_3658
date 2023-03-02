package Calculator.Math;

import Calculator.Parser.Parser;
import Calculator.Number.RationalNumber;
import Calculator.Parser.RationalParser;

public class RationalMath extends Math<RationalNumber> {
    public static RationalMath instance;

    private RationalMath() {
    }
    public static RationalMath getInstance() {
        if(instance == null)
            return new RationalMath();

        return instance;
    }

    @Override
    public RationalNumber sum(RationalNumber a, RationalNumber b) {
        int numA = (a.isNegative())? -(a.numerator()): a.numerator();
        int numB = (b.isNegative())? -(b.numerator()): b.numerator();
        int cDenominator = Math.nok(a.denominator(), b.denominator());
        int cNumerator =
                numA * (cDenominator / a.denominator()) +
                        numB * (cDenominator / b.denominator());

        return RationalNumber.create(cNumerator, cDenominator);
    }

    @Override
    public RationalNumber sub(RationalNumber a, RationalNumber b) {
        return sum(a, b.setNegative(!b.isNegative())
        );
    }

    @Override
    public RationalNumber mult(RationalNumber a, RationalNumber b) {
        int cNumerator = a.numerator() * b.numerator();
        int cDenominator = a.denominator() * b.denominator();
        int nod = Math.nod(cNumerator, cDenominator);
        cNumerator = cNumerator/nod;
        cDenominator = cDenominator/nod;
        return RationalNumber.create(cNumerator, cDenominator).setNegative(a.isNegative() ^ b.isNegative());
    }

    @Override
    public RationalNumber div(RationalNumber a, RationalNumber b) {
        RationalNumber revert = RationalNumber.create(b.denominator(), b.numerator()).setNegative(b.isNegative());
        return mult(a, revert);
    }

    @Override
    public String toString() {
        return "Калькурятор для рациональных чисел";
    }

    @Override
    public String description() {
        return "Введите выражение вида 1/2 + -3/7";
    }

    @Override
    public RationalNumber createNumberFromString(String s) {
        return RationalParser.getInstance().parse(s);
    }

    @Override
    public Parser<RationalNumber> parser() {
        return RationalParser.getInstance();
    }

}
