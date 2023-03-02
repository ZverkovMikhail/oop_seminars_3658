package Calculator;
import Calculator.Number.Number;
import Calculator.Model.MathMenu;
import Calculator.View.ConsoleView;
import java.util.Map;

/**
 * Создать калькулятор для работы с рациональными и комплексными числами, организовать меню,
 * добавив в неё систему логирования.
 */
public class Calculator {
    public void run() {
        ConsoleView view = ConsoleView.getInstance();
        while (true){
            var math = view.showMenu(new MathMenu());

            try {
                Map<String, String> rat = math.parser().split(view.getExpression(math.description()));

                Number n1 = math.createNumberFromString(rat.get("first"));
                Number n2 = math.createNumberFromString(rat.get("second"));

                var result = switch (rat.get("sign")) {
                    case "+" -> math.sum(n1, n2);
                    case "-" -> math.sub(n1, n2);
                    case ":" -> math.div(n1, n2);
                    case "*" -> math.mult(n1, n2);
                    default -> null;
                };

                view.printResult((Number) result);
            }catch (IllegalStateException e){
                view.printError("Введено не корректное выражение!");
            }
        }
    }
}
