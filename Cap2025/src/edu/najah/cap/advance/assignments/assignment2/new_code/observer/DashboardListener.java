package edu.najah.cap.advance.assignments.assignment2.new_code.observer;

import edu.najah.cap.advance.assignments.assignment2.new_code.Event;

public class DashboardListener implements EventListener {

    @Override
    public void onEventProcessed(Event e) {
        System.out.println(String.format(
                "[Dashboard] metrics updated for %s, payload: %s",
                e.getId(), e.getPayload()
        ));
    }
}
