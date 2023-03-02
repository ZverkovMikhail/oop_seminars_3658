package Calculator.View;
import Calculator.Model.MenuModel;
import Calculator.Number.Number;

public abstract class View<T> {
    public abstract T showMenu(MenuModel<T> menu);
    public abstract int getCommand();
    public abstract String getExpression(String text);
    public abstract void printResult(Number num);
    public abstract void printError(String text);
}
