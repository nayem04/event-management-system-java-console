package common.builders;

import models.Event;

import java.util.Date;

public class EventBuilder {
    private static EventBuilder eventBuilder;
    private Event event;

    private EventBuilder() {
    }

    public static EventBuilder getInstance() {
        if (eventBuilder == null) {
            eventBuilder = new EventBuilder();
        }
        return eventBuilder;
    }

    public EventBuilder create(Integer id, String name, String type, Date date, String venue, Integer capacity) {
        event = new Event(id, name, type, date, venue, capacity);
        return this;
    }

    public EventBuilder withSpeakerDetails(String speakerDetails) {
        event.setSpeakerDetails(speakerDetails);
        return this;
    }

    public EventBuilder withVIPAccess(boolean vipAccess) {
        event.setVipAccess(vipAccess);
        return this;
    }

    public Event build() {
        return event;
    }

}
