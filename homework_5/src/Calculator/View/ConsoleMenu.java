package Calculator.View;

import Calculator.Math.Math;

import java.util.Map;

public class ConsoleMenu implements Menu<Math>{
    private static ConsoleMenu instance = null;
    Map<Integer, Math> items;
    private ConsoleMenu() {
    }

    public static ConsoleMenu getInstance() {
        if(instance == null)
        return new ConsoleMenu();
        return instance;
    }

    @Override
    public void setMenuItems(Map<Integer, Math> items) {
        this.items = items;
    }

    @Override
    public Map<Integer, Math> items() {
        return this.items;
    }
}
