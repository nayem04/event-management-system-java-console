import controllers.EventController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Event Management System");

        int option;
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        EventController eventController = new EventController();

        while (!exit) {
            System.out.println("""
                    \nPlease enter a number between 1 to 5 to choose an option
                    1. Create a new event
                    2. Register a new User
                    3. View Analytics
                    4. Export Data
                    5. Exit The Program
                    """);

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number between 1 to 5 to choose an option");
                continue;
            } finally {
                scanner.nextLine();
            }

            switch (option) {
                case 1 -> eventController.createEvent(scanner);
                case 2 -> eventController.registerUser(scanner);
                case 3 -> eventController.viewAnalytics();
                case 4 -> eventController.exportData(scanner);
                case 5 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}