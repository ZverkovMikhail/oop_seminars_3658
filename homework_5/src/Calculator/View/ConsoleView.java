package Calculator.View;
import Logger.FileLogger;
import Calculator.Math.Math;
import Calculator.Number.Number;
import Calculator.Model.MenuModel;
import Logger.Logger;

import java.util.Map;
import java.util.Scanner;

public class ConsoleView extends View<Math> {

    private Logger log;
    private static ConsoleView instance = null;

    private ConsoleView() {
         log = FileLogger.init(this.getClass().getName());
    }

    public static ConsoleView getInstance() {
        if (instance == null)
            return new ConsoleView();
        return instance;
    }

    @Override
    public Math showMenu(MenuModel<Math> menu) {
        Math math = null;
        System.out.println("Данный клькулятор поддерживает математические операции:\n" +
                "(+) -> сложение\n" +
                "(-) -> вычитание\n" +
                "(*) -> умножение\n" +
                "(:) -> деление\n");
        for (Map.Entry<Integer, Math> m : menu.items.entrySet()) {
            printMenuItem(m.getKey(), m.getValue().toString());
        }
        printMenuItem(0, "Выход");
        while (math == null) {
            int command = getCommand();
            if (command == 0)
                System.exit(0);

            math = menu.items.get(command);
            if (math == null) {
                printError("Введена не корректная команда!");

            }
        }
        return math;
    }

    @Override
    public int getCommand() {
        String str = getExpression("Введите команду");
        log.info("Пользователь ввел команду >>> " + str);
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override
    public String getExpression(String text) {
        System.out.print(text + ": ");
        Scanner scanner = new Scanner(System.in);
        String ret = scanner.nextLine();
        log.info("Пользователь ввел >>> " + ret);
        return ret;
    }

    @Override
    public void printResult(Number num) {
        log.info("Результат вычислений >>> " + num);
        System.out.println("Результат = " + num);
    }

    @Override
    public void printError(String text) {
        log.warning(text);
        System.out.println(text);
    }

    private void printMenuItem(int command, String text) {
        System.out.printf("%d -> %s\n", command, text);
    }

}
