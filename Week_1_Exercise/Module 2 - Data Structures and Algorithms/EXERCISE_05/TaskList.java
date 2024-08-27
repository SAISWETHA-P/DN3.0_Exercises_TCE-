class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task[ID=" + taskId + ", Name=" + taskName + ", Status=" + status + "]";
    }
}
class TaskNode {
    Task task;
    TaskNode next;

    TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskList {
    private TaskNode head;

    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            return;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }

        TaskNode current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void traverseTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        taskList.addTask(new Task(1, "Design Database", "Pending"));
        taskList.addTask(new Task(2, "Develop API", "In Progress"));
        taskList.addTask(new Task(3, "Test Application", "Pending"));

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for Task with ID 2:");
        Task foundTask = taskList.searchTask(2);
        System.out.println(foundTask != null ? foundTask : "Task not found");

        System.out.println("\nDeleting Task with ID 1:");
        taskList.deleteTask(1);
        taskList.traverseTasks();
    }
}
