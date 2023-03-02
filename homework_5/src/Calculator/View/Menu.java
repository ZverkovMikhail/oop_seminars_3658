package Calculator.View;

import java.util.Map;

public interface Menu<T> {
    public void setMenuItems(Map<Integer, T> items);
    public Map<Integer, T> items();
}
