package Calculator.Number;

public class ComplexNumber extends Number<ComplexNumber> {
    private double a;
    private double b;
    private boolean isNegative;

    private ComplexNumber(double a, double b, boolean isNegative) {
        this.a = a;
        this.b = b;
        this.isNegative = isNegative;
    }

    public static ComplexNumber create(double a, double b) {
        return new ComplexNumber(a, b, false);
    }
@Override
    public ComplexNumber setNegative(boolean negative) {
        this.isNegative = negative;
        return this;
    }

    public double a() {
        return a;
    }

    public double b() {
        return b;
    }

    public boolean isNegative() {
        return isNegative;
    }

    @Override
    public String toString() {

        return String.format("%s %s %si",
                this.a,
                (isNegative) ? "-": "+",
                this.b
        );
    }
}
