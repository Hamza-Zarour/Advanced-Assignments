package edu.najah.cap.advance.assignments.assignment2.new_code;

import edu.najah.cap.advance.assignments.assignment2.new_code.observer.DashboardListener;
import edu.najah.cap.advance.assignments.assignment2.new_code.observer.EventPublisher;
import edu.najah.cap.advance.assignments.assignment2.new_code.observer.LoggerListener;
import edu.najah.cap.advance.assignments.assignment2.new_code.strategy.EventStrategyFactory;

public class App {

    public static void main(String[] args) {

        EventStrategyFactory factory = new EventStrategyFactory();

        EventPublisher publisher = new EventPublisher();
        publisher.subscribe(new DashboardListener());
        publisher.subscribe(new LoggerListener());

        EventProcessor eventProcessor = new EventProcessor(new Database(), factory, publisher);

        Event e1 = new Event("USER", "user-click");
        e1.setEncrypt(true);
        e1.setAddMetadata(true);
        e1.setMetadata("u=42");
        eventProcessor.process(e1);

        Event e2 = new Event("SECURITY", "failed-login");
        e2.setCompress(true);
        eventProcessor.process(e2);
    }
}
