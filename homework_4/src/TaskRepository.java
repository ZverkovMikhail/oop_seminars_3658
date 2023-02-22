import java.util.ArrayList;
import java.util.List;

public class TaskRepository<T> implements Repository<Task<T>> {
    private List<Task<T>> tasks;

    public TaskRepository(List<Task<T>> tasks) {
        this.tasks = tasks;
    }

    public TaskRepository() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void add(Task<T> task) {
        this.tasks.add(task);
    }

    @Override
    public Task<T> createElement(int id) {
        return new Task<T>(id);
    }

    public void saveToJson(String fileName) {
        Transfer t = new FileTransfer(fileName);
        Parser<Task<T>> p = new TaskJsonParser<>();
        t.write(p.dump(this.tasks));
    }

    public void loadFromJson(String fileName) {
        Transfer t = new FileTransfer(fileName);
        Parser<Task<T>> p = new TaskJsonParser<>();
        List<Task<T>> l = p.load(t.read());
        this.tasks = l;
    }

    @Override
    public List<Task<T>> getElements() {
        return tasks;
    }


}
