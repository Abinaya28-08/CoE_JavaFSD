import java.util.*;

class Task implements Comparable<Task> {
    private String id;
    private String description;
    private int priority;

    public Task(String id, String description, int priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priority, this.priority); // Higher priority comes first
    }

    @Override
    public String toString() {
        return "Task[ID=" + id + ", Description=" + description + ", Priority=" + priority + "]";
    }
}

class TaskManager {
    private PriorityQueue<Task> taskQueue;
    private Map<String, Task> taskMap;

    public TaskManager() {
        taskQueue = new PriorityQueue<>();
        taskMap = new HashMap<>();
    }

    public void addTask(String id, String description, int priority) {
        if (taskMap.containsKey(id)) {
            System.out.println("Task with ID " + id + " already exists.");
            return;
        }
        Task newTask = new Task(id, description, priority);
        taskQueue.add(newTask);
        taskMap.put(id, newTask);
    }

    public void removeTask(String id) {
        Task task = taskMap.remove(id);
        if (task != null) {
            taskQueue.remove(task);
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    public Task getHighestPriorityTask() {
        return taskQueue.peek();
    }

    public void displayTasks() {
        for (Task task : taskQueue) {
            System.out.println(task);
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("1", "Complete project report", 3);
        taskManager.addTask("2", "Prepare for meeting", 5);
        taskManager.addTask("3", "Reply to emails", 2);
        
        System.out.println("Highest Priority Task: " + taskManager.getHighestPriorityTask());
        
        taskManager.removeTask("2");
        
        System.out.println("After removing task 2:");
        taskManager.displayTasks();
    }
} 