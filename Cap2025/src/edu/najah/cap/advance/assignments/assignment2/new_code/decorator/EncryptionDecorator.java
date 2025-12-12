package edu.najah.cap.advance.assignments.assignment2.new_code.decorator;

import edu.najah.cap.advance.assignments.assignment2.new_code.Event;

public class EncryptionDecorator extends TransformerDecorator {

    public EncryptionDecorator(DataTransformer inner) {
        super(inner);
    }

    @Override
    public String transform(String data, Event e) {
        String result = super.transform(data, e);
        return "ENC(" + result + ")";
    }
}
