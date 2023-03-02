package Calculator.Model;
import Calculator.Math.ComplexMath;
import Calculator.Math.Math;
import Calculator.Math.RationalMath;

public class MathMenu extends MenuModel<Math> {
    public MathMenu() {
        this.items.put(1, RationalMath.getInstance());
        this.items.put(2, ComplexMath.getInstance());
    }
}
