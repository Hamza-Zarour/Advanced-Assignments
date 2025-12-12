package edu.najah.cap.advance.assignments.assignment2.new_code.decorator;

import edu.najah.cap.advance.assignments.assignment2.new_code.Event;

public abstract class TransformerDecorator implements DataTransformer {

    protected final DataTransformer inner;

    protected TransformerDecorator(DataTransformer inner) {
        this.inner = inner;
    }

    @Override
    public String transform(String data, Event e) {
        return inner.transform(data, e);
    }
}
