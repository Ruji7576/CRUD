package TaskOrganizer;


import java.util.Scanner;

    public class Taskorganizer {
        static String[] tasks = new String[100];
        static boolean[] completed = new boolean[100];
        static int counter = 0;
        static Scanner scanner = new Scanner(System.in);
    
        public static void main(String[] args) {
            int option;
    
            do {
                showMenu();
                option = scanner.nextInt();
                scanner.nextLine();
                executeOption(option);
            } while (option != 5);
    
            System.out.println("Exiting the application...");
        }
    
        static void showMenu() {
            System.out.println("Welcome to the ToDo List");
            System.out.println("=========================");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
        }
    
        static void executeOption(int option) {
            switch(option) {
                case 1 -> addTask();
                case 2 -> deleteTask();
                case 3 -> listTasks();
                case 4 -> markTaskCompleted();
                case 5 -> {
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
            // Exit
                    }
    
        static void addTask() {
            if (counter < 100) {
                System.out.print("Enter the description of the new task: ");
                String description = scanner.nextLine();
                tasks[counter] = description;
                completed[counter] = false;
                counter++;
                System.out.println("Task successfully added.");
            } else {
                System.out.println("The task list is full.");
            }
        }
    
        static void deleteTask() {
            System.out.print("Enter the number of the task to delete: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Clear the buffer
    
            if (index >= 0 && index < counter) {
                for (int i = index; i < counter - 1; i++) {
                    tasks[i] = tasks[i + 1];
                    completed[i] = completed[i + 1];
                }
                tasks[counter - 1] = null;
                completed[counter - 1] = false;
                counter--;
                System.out.println("Task successfully deleted.");
            } else {
                System.out.println("Invalid index.");
            }
        }
    
        static void listTasks() {
            System.out.println("Task List:");
            for (int i = 0; i < counter; i++) {
                String status = completed[i] ? "[X]" : "[ ]";
                System.out.println((i + 1) + ". " + status + " " + tasks[i]);
            }
        }
    
        static void markTaskCompleted() {
            System.out.print("Enter the number of the task to mark as completed: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Clear the buffer
    
            if (index >= 0 && index < counter) {
                completed[index] = true;
                System.out.println("Task marked as completed.");
            } else {
                System.out.println("Invalid index.");
            }
        }
    }