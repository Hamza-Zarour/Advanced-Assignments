package edu.najah.cap.advance.assignments.assignment2.new_code.decorator;

import edu.najah.cap.advance.assignments.assignment2.new_code.Event;

public class BaseTransformer implements DataTransformer {

    @Override
    public String transform(String data, Event e) {
        return data;
    }
}
