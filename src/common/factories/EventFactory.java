package common.factories;

import common.builders.EventBuilder;
import models.Event;

import java.util.Date;

public class EventFactory {
    EventBuilder eventBuilder;

    public EventFactory() {
        eventBuilder = EventBuilder.getInstance();
    }

    public Event createEvent(Integer id, String name, String type, Date date, String venue, Integer capacity) {
        eventBuilder = eventBuilder.create(id, name, type, date, venue, capacity);

        if (type.equalsIgnoreCase("seminar")) {
            return eventBuilder.withSpeakerDetails("Speaker").build();
        } else if (type.equalsIgnoreCase("concert")) {
            return eventBuilder.withVIPAccess(true).build();
        }
        return eventBuilder.build();
    }
}
