package Calculator.Number;

public class RationalNumber extends Number<RationalNumber> {
    private int numerator;
    private int denominator;
    private boolean isNegative;

    private RationalNumber(int numerator, int denominator, boolean isNegative) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.isNegative = isNegative;
    }

    public static RationalNumber create(int numerator, int denominator) {
        return new RationalNumber(numerator, denominator, false);
    }

    public static RationalNumber create(int num) {
        return new RationalNumber(num, 1, false);
    }

    public RationalNumber setNegative(boolean negative) {
        this.isNegative = negative;
        return this;
    }

    public int numerator() {
        return numerator;
    }

    public int denominator() {
        return denominator;
    }

    public boolean isNegative() {
        return isNegative;
    }

    @Override
    public String toString() {

        return String.format("%s%d/%d",
                (isNegative) ? "-": "",
                this.numerator,
                this.denominator
        );
    }
}

