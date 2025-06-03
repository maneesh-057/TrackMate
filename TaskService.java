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
        System.out.println("************** ADD TASK OPERATION **************");
        tasks.add(task);
        fileHandler.writeTasks(tasks);
        System.out.println("✅ Task added successfully!");
    }

    public void viewTasks() {
        System.out.println("************** VIEW TASK OPERATION **************");
        if (tasks.isEmpty()) {
            System.out.println("⚠️ No tasks found.");
            return;
        }
        for (Task task : tasks) {
            task.printTask();
        }
    }

    public void updateTask() {
        System.out.println("************** UPDATE TASK OPERATION **************");
        System.out.print("Enter the ID of the task to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        boolean found = false;
        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.print("Enter new title: ");
                String newTitle = sc.nextLine();
                System.out.print("Enter new description: ");
                String newDescription = sc.nextLine();
                System.out.print("Enter new due date (DD-MM-YYYY): ");
                String newDueDate = sc.nextLine();

                // Set updated values using getters/setters
                // Entity names remain unchanged per your request
                task.setCompleted(false); // Assume reset to not completed
                task = new Task(task.getId(), newTitle, newDescription, newDueDate, false);

                tasks.set(tasks.indexOf(task), task);
                fileHandler.writeTasks(tasks);
                System.out.println("✅ Task updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("⚠️ Task not found with ID: " + id);
        }
    }

    public void deleteTask() {
        System.out.println("************** DELETE TASK OPERATION **************");
        System.out.print("Enter the ID of the task to delete: ");
        int id = sc.nextInt();

        boolean removed = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                removed = true;
                break;
            }
        }

        if (removed) {
            fileHandler.writeTasks(tasks);
            System.out.println("🗑️ Task deleted successfully.");
        } else {
            System.out.println("⚠️ Task not found with ID: " + id);
        }
    }

    public int generateTaskId() {
        return tasks.size() + 1;
    }
}
