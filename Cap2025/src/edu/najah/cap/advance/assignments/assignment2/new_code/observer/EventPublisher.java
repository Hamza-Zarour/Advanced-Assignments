package edu.najah.cap.advance.assignments.assignment2.new_code.observer;

import edu.najah.cap.advance.assignments.assignment2.new_code.Event;

import java.util.ArrayList;
import java.util.List;

public class EventPublisher {

    private final List<EventListener> listeners = new ArrayList<>();

    public void subscribe(EventListener listener) {
        listeners.add(listener);
    }

    public void publish(Event e) {
        for (EventListener l : listeners) {
            l.onEventProcessed(e);
        }
    }
}
