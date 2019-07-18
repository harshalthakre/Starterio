package com.project.starterio_version_1.model;

import javax.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private int eventId;
    private String eventName;
    private String eventDescription;
    private String eventImage;
    private String eventDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public User getUser() {
        return user;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventImage() {
        return eventImage;
    }

    public String getEventName() {
        return eventName;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
