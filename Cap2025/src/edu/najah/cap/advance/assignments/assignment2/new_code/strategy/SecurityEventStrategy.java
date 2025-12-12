package edu.najah.cap.advance.assignments.assignment2.new_code.strategy;

import edu.najah.cap.advance.assignments.assignment2.new_code.Event;

public class SecurityEventStrategy implements EventStrategy {
    @Override
    public void execute(Event event) {
        System.out.println("[SECURITY] extra analysis for " + event.getId());
        System.out.println("[SecurityMonitor] alert for " + event.getId());
    }
}
