package model;

import java.util.Calendar;
import java.util.Date;

// Represent an event
public class Event {
    private static final int HASH_CONSTANT = 13;
    private Date dateLogged;
    private String description;

    // REQUIRES: description be a String
    // EFFECTS: Creates an event with the given description and the current date/time stamp.
    public Event(String description) {
        dateLogged = Calendar.getInstance().getTime();
        this.description = description;
    }

    public Date getDate() {
        return dateLogged;
    }

    public String getDescription() {
        return description;
    }

    // See java.lang.Object.equals
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Event otherEvent = (Event) other;

        return (this.dateLogged.equals(otherEvent.dateLogged)
                && this.description.equals(otherEvent.description));
    }

    // See java.lang.Object.hashCode
    @Override
    public int hashCode() {
        return (HASH_CONSTANT * dateLogged.hashCode() + description.hashCode());
    }

    // EFFECTS: returns a String value of the event
    @Override
    public String toString() {
        return dateLogged.toString() + "\n" + description;
    }
}
