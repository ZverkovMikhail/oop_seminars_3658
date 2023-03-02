package Calculator.Math;

import Calculator.Number.Number;
import Calculator.Parser.Parser;

public abstract class Math<T extends Number> implements Sum<T>, Sub<T>, Multiplication<T>, Division<T> {
    static int nok(int a, int b) {
        return a * b / nod(a, b);
    }

    static int nod(int a, int b) {
        if (b == 0) {
            return a;
        }
        return nod(b, a % b);
    }
    public abstract String description();
    public abstract T createNumberFromString(String s);
    public abstract Parser<T> parser();
    public abstract String toString();
}
