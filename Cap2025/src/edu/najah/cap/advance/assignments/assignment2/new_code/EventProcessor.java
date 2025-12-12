package edu.najah.cap.advance.assignments.assignment2.new_code;

import edu.najah.cap.advance.assignments.assignment2.new_code.decorator.DataTransformer;
import edu.najah.cap.advance.assignments.assignment2.new_code.decorator.TransformerChainBuilder;
import edu.najah.cap.advance.assignments.assignment2.new_code.observer.EventPublisher;
import edu.najah.cap.advance.assignments.assignment2.new_code.strategy.EventStrategyFactory;

public class EventProcessor {

    private final Database database;
    private final TransformerChainBuilder chainBuilder = new TransformerChainBuilder();
    private final EventStrategyFactory strategyFactory;
    private final EventPublisher publisher;

    public EventProcessor(Database database, EventStrategyFactory strategyFactory, EventPublisher publisher) {
        this.database = database;
        this.strategyFactory = strategyFactory;
        this.publisher = publisher;
    }

    public void process(Event e) {
        // validate
        if (e.getPayload() == null || e.getPayload().isEmpty()) {
            System.out.println("Invalid event");
            return;
        }

        // transform (Decorator)
        DataTransformer transformer = chainBuilder.buildFor(e);
        String data = transformer.transform(e.getPayload(), e);

        // observers see the processed payload
        e.setPayload(data);

        // generate id
        e.setId(System.currentTimeMillis() + "-" + Math.abs(data.hashCode()));

        // persist
        database.save(e.getId(), data);

        // notify observers
        publisher.publish(e);

        // Strategy
        strategyFactory.getStrategy(e.getType()).execute(e);
    }
}
