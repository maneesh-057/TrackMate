// #File read/write operations for data.txt.
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private final String filePath = "tasks.txt";

    public FileHandler() {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("Task file created: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    public void writeTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                writer.write(task.getId() + ";" + task.getTitle() + ";" + task.getDescription() + ";" +
                        task.getDueDate() + ";" + task.isCompleted());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public List<Task> readTasks() {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 5) {
                    Task task = new Task(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            data[3],
                            Boolean.parseBoolean(data[4])
                    );
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return tasks;
    }
}

