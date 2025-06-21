public class TaskLinkedList {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        System.out.println("✅ Task added: " + task);
    }

    public void removeTask(String taskId) {
        if (head == null)
            return;

        if (head.task.taskId.equals(taskId)) {
            head = head.next;
            System.out.println("🗑️ Task removed: " + taskId);
            return;
        }

        Node curr = head;
        while (curr.next != null && !curr.next.task.taskId.equals(taskId)) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
            System.out.println("🗑️ Task removed: " + taskId);
        } else {
            System.out.println("❌ Task not found: " + taskId);
        }
    }

    public void viewTasks() {
        Node curr = head;
        System.out.println("📝 Task List:");
        while (curr != null) {
            System.out.println(curr.task);
            curr = curr.next;
        }
    }
}
