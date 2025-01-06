package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {
    private Integer id;
    private String name;
    private String type;
    private Date date;
    private String venue;
    private Integer capacity;
    private Integer registrations;
    private String speakerDetails;
    private boolean vipAccess;
    private List<Integer> userIds;

    public Event(Integer id, String name, String type, Date date, String venue, Integer capacity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.date = date;
        this.venue = venue;
        this.capacity = capacity;
        registrations = 0;
        userIds = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Integer registrations) {
        this.registrations = registrations;
    }

    public String getSpeakerDetails() {
        return speakerDetails;
    }

    public void setSpeakerDetails(String speakerDetails) {
        this.speakerDetails = speakerDetails;
    }

    public boolean isVipAccess() {
        return vipAccess;
    }

    public void setVipAccess(boolean vipAccess) {
        this.vipAccess = vipAccess;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public boolean addRegistrations() {
        if (!isFullyBooked()) {
            registrations++;
            return true;
        }
        return false;
    }

    public boolean isFullyBooked() {
        return registrations.equals(capacity);
    }

    @Override
    public String toString() {
        return "Event{id = " + id + ", name = " + name + ", type = " + type + ", date = " + date +
                ", venue = " + venue + ", capacity = " + capacity + ", registrations = " + registrations + "}";
    }
}
