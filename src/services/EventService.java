package services;

import common.exceptions.DuplicateRegistrationException;
import common.exceptions.NoSuchEventException;
import common.factories.EventFactory;
import common.validations.Email;
import common.validations.Phone;
import common.validations.Validator;
import models.Event;
import models.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class EventService {
    private static EventService eventService;
    private final EventFactory eventFactory;
    private final Map<Integer, Event> events = new HashMap<>();
    private static final Map<Integer, User> users = new HashMap<>();

    private EventService() {
        eventFactory = new EventFactory();
    }

    public static EventService getInstance() {
        if (eventService == null) {
            eventService = new EventService();
        }
        return eventService;
    }

    public void createEvent(Integer id, String name, String type, String inputDate, String venue, Integer capacity) {
        Date date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = dateFormat.parse(inputDate);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }

        Event event = eventFactory.createEvent(id, name, type, date, venue, capacity);
        events.put(id, event);
        System.out.println("Event created successfully!");
    }

    public void registerUser(Integer eventId, Integer id, String name, String email, String phone) throws DuplicateRegistrationException, NoSuchEventException {
        if (!events.containsKey(eventId)) {
            throw new NoSuchEventException("Event with id " + eventId + " does not exist!");
        }

        if (!users.containsKey(id)) {
            if (!Email.validate(email)) {
                throw new InputMismatchException("Invalid email address. Please try again!");
            } else if (!Phone.validate(phone)) {
                throw new InputMismatchException("Invalid phone number. Please try again!");
            }

            User user = new User(id, name, email, phone);
            users.put(id, user);
        }

        Event event = events.get(eventId);

        if (event.getUserIds().contains(id)) {
            throw new DuplicateRegistrationException("User with id " + id + " already register for this event.");
        }

        if(event.addRegistrations()) {
            event.getUserIds().add(id);
            System.out.println("User registrations done successfully!");
        } else {
            System.out.println("Can't register for this event. It's fully booked");
        }
    }

    public void viewAnalytics() {
        long totalUsers = users.size();
        double occupancyPercentage = events.values().stream()
                .mapToDouble(e -> (double) e.getRegistrations() / e.getCapacity() * 100)
                .average()
                .orElse(0.0);

        System.out.println("Analytics:\nTotal Users: " + totalUsers);
        System.out.println("Event Occupancy Percentage: " + String.format("%.2f", occupancyPercentage) + "%");

        System.out.println("\nEvent-Specific Analytics:");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-12s %-20s %-15s %-10s\n", "Event ID", "Name", "Occupancy (%)", "Fully Booked");
        System.out.println("--------------------------------------------------------------");

        for (Event event : events.values()) {
            double occupancy = ((double) event.getRegistrations() / event.getCapacity()) * 100;
            System.out.printf("%-12s %-20s %-15.2f %-10s\n",
                    event.getId(),
                    event.getName(),
                    occupancy,
                    event.isFullyBooked() ? "Yes" : "No");
        }

        System.out.println("--------------------------------------------------------------");
    }
}
