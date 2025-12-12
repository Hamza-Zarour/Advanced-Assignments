package edu.najah.cap.advance.assignments.assignment2.new_code.decorator;

import edu.najah.cap.advance.assignments.assignment2.new_code.Event;

public class TransformerChainBuilder {

    public DataTransformer buildFor(Event e) {

        DataTransformer transformer = new BaseTransformer();

        if (e.isEncrypt()) {
            transformer = new EncryptionDecorator(transformer);
        }
        if (e.isCompress()) {
            transformer = new CompressionDecorator(transformer);
        }
        if (e.isAddMetadata()) {
            transformer = new MetadataDecorator(transformer);
        }

        return transformer;
    }
}
