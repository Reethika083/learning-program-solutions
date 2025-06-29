public class Task {
    String taskId;
    String description;

    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task[ID=" + taskId + ", Desc=" + description + "]";
    }
}
