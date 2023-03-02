package Calculator.Model;

import java.util.HashMap;
import java.util.Map;

public abstract class MenuModel<T> {
    public final Map<Integer, T> items = new HashMap<>();

}
