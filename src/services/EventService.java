package services;

public class EventService {
    private static EventService eventService;

    private EventService() {
    }

    public static EventService getInstance() {
        if (eventService == null) {
            eventService = new EventService();
        }
        return eventService;
    }


}
