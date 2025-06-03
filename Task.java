public class Task {
    private int id;
    private String title;
    private String description;
    private String dueDate;
    private boolean isCompleted;

    public Task(int id, String title, String description, String dueDate, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void printTask() {
        System.out.println("------------ Task Details ------------");
        System.out.println("Task ID      : " + id);
        System.out.println("Title        : " + title);
        System.out.println("Description  : " + description);
        System.out.println("Due Date     : " + dueDate);
        System.out.println("Completed    : " + (isCompleted ? "Yes" : "No"));
        System.out.println("--------------------------------------");
    }

    @Override
    public String toString() {
        return "Task ID: " + id +
               " | Title: " + title +
               " | Description: " + description +
               " | Due Date: " + dueDate +
               " | Completed: " + (isCompleted ? "Yes" : "No");
    }
}
