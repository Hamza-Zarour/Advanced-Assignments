package edu.najah.cap.advance.assignments.assignment2.new_code.strategy;

import edu.najah.cap.advance.assignments.assignment2.new_code.Event;

public class SystemEventStrategy implements EventStrategy {
    @Override
    public void execute(Event event) {
        System.out.println("[SYSTEM] system audit log " + event.getId());
    }
}
