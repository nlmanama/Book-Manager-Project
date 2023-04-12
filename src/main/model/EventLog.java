package model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


// Represent an event log of the library, implement the Singleton Design Pattern to ensure that there is only one
// event log in the system
public class EventLog implements Iterable<Event> {

    private static EventLog theLog;
    private Collection<Event> events;

    //EFFECTS: Create an instance of an event log, cannot be called outside the class
    private EventLog() {
        events = new ArrayList<Event>();
    }

    // MODIFIES: this
    // EFFECTS: return the instance of EventLog, if none exist then creates it
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }

        return theLog;
    }

    // REQUIRES: e be an Event
    // MODIFIES: this
    // EFFECTS: adds an event to the log
    public void logEvent(Event e) {
        events.add(e);
    }

    // MODIFIES: this
    // EFFECTS: clears the event log
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
