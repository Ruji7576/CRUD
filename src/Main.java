package orderlist;

import java.util.Scanner;

public class ToDoList {
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
        switch (option) {
            case 1:
                addTask();
                break;
            case 2:
                deleteTask();
                break;
            case 3:
                listTasks();
                break;
            case 4:
                markTaskCompleted();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}