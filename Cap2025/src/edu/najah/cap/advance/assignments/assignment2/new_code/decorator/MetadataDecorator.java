package edu.najah.cap.advance.assignments.assignment2.new_code.decorator;

import edu.najah.cap.advance.assignments.assignment2.new_code.Event;

public class MetadataDecorator extends TransformerDecorator {

    public MetadataDecorator(DataTransformer inner) {
        super(inner);
    }

    @Override
    public String transform(String data, Event e) {
        String result = super.transform(data, e);
        return "META(" + e.getMetadata() + ")::" + result;
    }
}
