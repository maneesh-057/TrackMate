
// #Main class with the menu and user interaction.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskService todo = new TaskService();

        while (true) {
            System.out.println("************** TASK MANAGER **************");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update a Task");
            System.out.println("4. Delete a Task");

            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1: 
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    if (!Validation.isValidTitle(title)) {
                        System.out.println(" ***** Invalid-title *****");
                        break;
                    }

                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter due date (dd-mm-yyyy): ");
                    String dueDate = sc.nextLine();
                    if (!Validation.isValidDate(dueDate)) {

                        System.out.println(" ***** Invalid date format *****");
                        break;
                    }

                    int id = todo.generateTaskId();
                    Task task = new Task(id, title, desc, dueDate, false);
                    todo.addTask(task);
                
                case 2 : 
                    todo.viewTasks();
                    break;
                case 3: 
                    todo.updateTask();
                    break;
                case 4: 
                    todo.deleteTask();
                    break;

                default: 
                    System.out.println("Please Enter Correct Input");
            }
            
            System.out.println("Press 1 to Continue, Any other no for Finishing");
            if((sc.nextInt()) != 1){
                System.out.println("Thanks...See You Soon!");
                break;
            }
            
        }
    }
}
