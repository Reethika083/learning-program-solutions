public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task("T001", "Fix bug in login"));
        taskList.addTask(new Task("T002", "Prepare presentation"));
        taskList.addTask(new Task("T003", "Review PR"));

        taskList.viewTasks();

        taskList.removeTask("T002");

        System.out.println("\nAfter removal:");
        taskList.viewTasks();
    }
}
