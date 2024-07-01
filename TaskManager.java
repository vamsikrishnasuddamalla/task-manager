import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getChoice(scanner);

            switch (choice) {
                case 1:
                    addTask(taskList, scanner);
                    break;
                case 2:
                    removeTask(taskList, scanner);
                    break;
                case 3:
                   1
                    listTasks(taskList);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nTask Manager");
        System.out.println("1. Add a task");
        System.out.println("2. Remove a task");
        System.out.println("3. List tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static int getChoice(Scanner scanner) {
        int choice = -1;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        }
        scanner.nextLine();  // Consume newline
        return choice;
    }

    public static void addTask(TaskList taskList, Scanner scanner) {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        taskList.addTask(description);
        System.out.println("Task added.");
    }

    public static void removeTask(TaskList taskList, Scanner scanner) {
        System.out.print("Enter task number to remove: ");
        int taskNumber = getChoice(scanner) - 1;
        taskList.removeTask(taskNumber);
    }

    public static void listTasks(TaskList taskList) {
        System.out.println("Task List:");
        taskList.listTasks();
    }
}

class Task {
    private String description;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}

class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}