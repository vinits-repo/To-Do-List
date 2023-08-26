
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

       System.out.println("Welcome to the your To Do List ");

        String task;
        while (true) {
            System.out.println("\nOptions :");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Remove Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.println("Enter your choice (1-5): ");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the task : ");
                    task = in.nextLine();
                    toDoList.addTask(task);
                    System.out.println("Task Added");
                }
                case 2 -> {
                    System.out.println("Enter the task index to mark as completed: ");
                    int completedTask = in.nextInt() - 1;
                    toDoList.taskGetsCompleted(completedTask);
                }
                case 3 -> {
                    System.out.println("Enter the task index to remove the task: ");
                    int removeTask = in.nextInt() - 1;
                    toDoList.removeTask(removeTask);
                }
                case 4 -> toDoList.viewTasks();
                case 5 -> {
                    System.out.println("Exit the program." + "\nThank You for using To Do List");
                    in.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice. Please try again.");
            }

        }

    }

    private ArrayList<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }



    public void taskGetsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            String task = tasks.get(index);
          //  tasks.set(index, "[Completed] " + task);
            if (task.startsWith("[Completed] ")) {
                System.out.println("Task already marked as completed: " + task);
            } else {
                tasks.set(index, "[Completed] " + task);
                System.out.println("Task marked as completed: " + tasks.get(index));
            }
        }else {
            System.out.println("Invalid Task index!");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }else {
            System.out.println("Invalid Task index!");
        }

    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No Task Found.");
        }else {
            System.out.println("Tasks : ");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + "." + tasks.get(i));
            }
        }
    }

}
