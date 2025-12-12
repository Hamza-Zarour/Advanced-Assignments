package edu.najah.cap.advance.assignments.assignment2.new_code.strategy;

import edu.najah.cap.advance.assignments.assignment2.new_code.Event;

public class UserEventStrategy implements EventStrategy {
    @Override
    public void execute(Event event) {
        System.out.println("[USER] user-specific step for " + event.getId());
    }
}
