package Calculator.Math;

import Calculator.Number.ComplexNumber;
import Calculator.Parser.ComplexParser;
import Calculator.Parser.Parser;

public class ComplexMath extends Math<ComplexNumber> {
    public static ComplexMath instance;

    private ComplexMath() {
    }

    public static ComplexMath getInstance() {
        if (instance == null)
            return new ComplexMath();

        return instance;
    }

    @Override
    public ComplexNumber createNumberFromString(String s) {
        return parser().parse(s);
    }

    @Override
    public Parser<ComplexNumber> parser() {
        return ComplexParser.getInstance();
    }


    @Override
    public String description() {
        return "Введите выражение вида (7 + 10i) * (2 - 3i)";
    }

    @Override
    public String toString() {
        return "Калькулятор комплексных чисел";
    }

    @Override
    public ComplexNumber sum(ComplexNumber a, ComplexNumber b) {
        double aSum = a.a() + b.a();
        double bSum = a.b() + b.b();
        var ret = ComplexNumber.create(aSum, bSum);
        if (bSum < 0)
            ret.setNegative(true);
        return ret;
    }

    @Override
    public ComplexNumber sub(ComplexNumber a, ComplexNumber b) {

        double aSub = a.a() - b.a();
        double bSub = a.b() - b.b();
        var ret = ComplexNumber.create(aSub, bSub);
        if (bSub < 0)
            ret.setNegative(true);
        return ret;
    }

    @Override
    public ComplexNumber mult(ComplexNumber a, ComplexNumber b) {
        double aMult = a.a() * b.a() - a.b() * b.b();
        double bMult = a.a() * b.b() + a.b() * b.a();
        var ret = ComplexNumber.create(aMult, bMult);
        if (bMult < 0)
            ret.setNegative(true);
        return ret;
    }


    @Override
    public ComplexNumber div(ComplexNumber a, ComplexNumber b) {
        double denominator = b.a() * b.a() + b.b() * b.b();
        double aDiv = (a.a() * b.a() + a.b() * b.b()) / denominator;
        double bDiv = (b.a() * a.b() - a.a() * b.b()) / denominator;
        var ret = ComplexNumber.create(aDiv, bDiv);
        if (bDiv < 0)
            ret.setNegative(true);
        return ret;
    }
}
