package services;

import common.factories.EventFactory;
import models.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EventService {
    private static EventService eventService;
    private final Map<Integer, Event> events = new HashMap<>();
    private final EventFactory eventFactory;

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
        System.out.println("Event created successfully! " + events);
    }
}
