package controllers;

import common.exceptions.DuplicateRegistrationException;
import common.exceptions.NoSuchEventException;
import services.EventService;

import java.util.Scanner;

public class EventController {
    private final EventService eventService;

    public EventController() {
        eventService = EventService.getInstance();
    }

    public void createEvent(Scanner scanner) {
        System.out.print("Enter Event ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Event Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Event Type: ");
        String type = scanner.nextLine();

        System.out.print("Enter Event Date (yyyy-mm-dd): ");
        String inputDate = scanner.nextLine();

        System.out.print("Enter Venue: ");
        String venue = scanner.nextLine();

        System.out.print("Enter Capacity: ");
        Integer capacity = scanner.nextInt();

        eventService.createEvent(id, name, type, inputDate, venue, capacity);
    }

    public void registerUser(Scanner scanner) {
        System.out.print("Enter Event ID: ");
        Integer eventId = scanner.nextInt();

        System.out.print("Enter User ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        try {
            eventService.registerUser(eventId, id, name, email, phone);
        } catch (DuplicateRegistrationException duplicateRegistrationException) {
            System.out.println("Duplicate Registration: " + duplicateRegistrationException.getMessage());
        } catch (NoSuchEventException noSuchEventException) {
            System.out.println("No Such Event: " + noSuchEventException.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void viewAnalytics() {
        eventService.viewAnalytics();
    }

    public void exportData(Scanner scanner) {
        System.out.print("Enter file format (CSV/JSON): ");
        String format = scanner.nextLine();
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        eventService.exportData(format, fileName);
    }
}
