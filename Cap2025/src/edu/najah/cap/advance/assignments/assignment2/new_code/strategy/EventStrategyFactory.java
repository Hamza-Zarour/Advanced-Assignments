package edu.najah.cap.advance.assignments.assignment2.new_code.strategy;

public class EventStrategyFactory {

    public EventStrategy getStrategy(String eventType) {
        if (eventType == null) {
            throw new IllegalArgumentException("Event Type cannot be null");
        }

        switch (eventType.trim().toUpperCase()) {
            case "USER":
                return new UserEventStrategy();
            case "SYSTEM":
                return new SystemEventStrategy();
            case "SECURITY":
                return new SecurityEventStrategy();
            default:
                throw new IllegalArgumentException("Unknown Event type: " + eventType);
        }
    }
}
