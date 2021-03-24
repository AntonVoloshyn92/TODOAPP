package anton.dev.todoapp.model.entity;

public class Task {
    private String description;

    public Task() {
    }

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
