import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    static class Task {
        String description;
        boolean isDone;

        Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        void markAsDone() {
            this.isDone = true;
        }

        @Override
        public String toString() {
            return (isDone ? "[X] " : "[ ] ") + description;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("\n===== TO-DO LIST =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Task");
            System.out.println("3. Mark task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("No input entered. Please try again.");
                continue;
            }

            switch (input) {
                case "1":
                    System.out.println("Enter task description: ");
                    String desc = scanner.nextLine();
                    tasks.add(new Task(desc));
                    System.out.println("Task added!");
                    break;
                case "2":
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks yet.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;
                case "3":
                    System.out.print("Enter task number to mark as done: ");
                    int doneIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    if (doneIndex >= 0 && doneIndex < tasks.size()) {
                        tasks.get(doneIndex).markAsDone();
                        System.out.println("Task marked as done!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case "4":
                    System.out.print("Enter task number to delete: ");
                    int deleteIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    if (deleteIndex >= 0 && deleteIndex < tasks.size()) {
                        tasks.remove(deleteIndex);
                        System.out.println("Task deleted!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}