import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskPlanner<T> {
    TaskRepository<T> repository;
    PriorityChecker checker;

    public TaskPlanner(TaskRepository<T> repository, PriorityChecker checker) {
        this.repository = repository;
        this.checker = checker;
    }

    public List<Task<T>>getTasksByPriority(Priority priority){
        return repository.getElements().stream().filter(tTask -> checker.check(tTask, priority)).toList();
    }

    public Map<Priority, List<Task<T>>> getPlane(){
        Map<Priority, List<Task<T>>> plane = new HashMap<>();
        for(Priority p: Priority.values()){
            plane.put(p, getTasksByPriority(p));
        }
        return plane;
    }
}
