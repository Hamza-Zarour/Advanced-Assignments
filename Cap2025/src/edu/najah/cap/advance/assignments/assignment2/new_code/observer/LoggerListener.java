package edu.najah.cap.advance.assignments.assignment2.new_code.observer;

import edu.najah.cap.advance.assignments.assignment2.new_code.Event;

public class LoggerListener implements EventListener {

    @Override
    public void onEventProcessed(Event event) {
        System.out.println("[LOG] Processed event " + event.getId() + " type " + event.getType());
    }
}
