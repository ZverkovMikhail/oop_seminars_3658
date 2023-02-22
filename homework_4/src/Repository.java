import java.util.List;

public interface Repository<T> {
    public void add(T el);
    public List<T> getElements();
    public T createElement(int id);
}
