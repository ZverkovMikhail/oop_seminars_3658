import java.time.LocalDateTime;

public class Task<T> {
    private int id;
    private T body;
    private LocalDateTime deadline;
    private LocalDateTime addedTime;
    private String authorName;

    public Task(int id) {
        this.id = id;
        this.body = null;
        this.deadline = null;
        this.addedTime = null;
        this.authorName = null;
    }

    public Task<T> setBody(T body) {
        this.body = body;
        return this;
    }

    public Task<T> setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
        return this;
    }

    public Task<T> setAddedTime(LocalDateTime addedTime) {
        this.addedTime = addedTime;
        return this;
    }

    public Task<T> setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public int id() {
        return id;
    }

    public T body() {
        return body;
    }

    public LocalDateTime deadlineData() {
        return deadline;
    }

    public LocalDateTime addedTime() {
        return addedTime;
    }

    public String authorName() {
        return authorName;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.body(), this.deadline);
    }
}
