package controllers;

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
    }

    public void viewAnalytics() {
    }

    public void exportData(Scanner scanner) {
    }
}
