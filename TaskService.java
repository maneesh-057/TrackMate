
// #	Logic for CRUD operations (add, view, delete, update tasks).	Logic for CRUD operations (add, view, delete, update tasks).
import java.util.*;

public class TaskService {
    static Scanner sc = new Scanner(System.in);
    private List<Task> tasks;
    private FileHandler fileHandler;

    public TaskService() {
        fileHandler = new FileHandler();
        tasks = fileHandler.readTasks();
    }

    public void addTask(Task task) {
        System.out.println("************** Add TASK OPERATION **************");
        tasks.add(task);
        fileHandler.writeTasks(tasks);
        System.out.println("✅ Task added successfully!");
    }

    public void viewTasks() {
        System.out.println("************** View TASK OPERATION **************");
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(tasks);
        }
    }

    public void updateTask() {
        System.out.println("************** UPDATE TASK OPERATION **************");
        System.out.print("Enter the ID of the task to update: ");
        int id = sc.nextInt();

        boolean found = false;
        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.print("Enter new title: ");
                task.title = (sc.nextLine());

                System.out.print("Enter new description: ");
                task.description = (sc.nextLine());

                System.out.print("Enter new due date (DD-MM-YYYY): ");
                task.dueDate = (sc.nextLine());

                System.out.print("Enter new status (Pending/In Progress/Completed): ");
                task.isCompleted = true;

                found = true;
                fileHandler.writeTasks(tasks);
                System.out.println("Changes saved successfully");
                break;
            }
        }

        if (!found) {
            System.out.println("Task not found with ID: " + id);
        }

        fileHandler.writeTasks(tasks); // Save changes to file
    }

    public void deleteTask() {
        System.out.println("************** DELETED TASK OPERATION **************");

        System.out.print("Enter the ID of the task to delete: ");
        int id = sc.nextInt();

        boolean remove = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                remove = true;
                break; 
            }
        }

        if (remove) {
            System.out.println("🗑️ Task deleted successfully.");
            fileHandler.writeTasks(tasks);
        } else {
            System.out.println("Task not found with ID: " + id);
        }
    }

    public int generateTaskId() {
        return (tasks.size() + 1);
    }
}
