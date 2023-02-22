import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;

public class PriorityChecker {
    Map<Priority, Integer> properties;

    private PriorityChecker() {
        properties = new HashMap<>();
    }

    public static PriorityChecker create() {
        return new PriorityChecker();
    }

    public PriorityChecker appendProperty(Priority p, int days) {
        properties.put(p, days);
        return this;
    }

    public Priority check(Task t) {
        int daysLeft = (int) DAYS.between(LocalDateTime.now(), t.deadlineData());
        int daysTemp = Integer.MAX_VALUE;
        Priority priority = Priority.LOW;
        for (Map.Entry<Priority, Integer> entry : properties.entrySet()) {
            if (daysLeft <= entry.getValue() && daysTemp > entry.getValue()) {
                priority = entry.getKey();
                daysTemp = entry.getValue();
            }
        }
        return priority;
    }

    public boolean check(Task t, Priority p) {
        return p == check(t);
    }
}
