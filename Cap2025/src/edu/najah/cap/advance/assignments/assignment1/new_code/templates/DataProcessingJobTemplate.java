package edu.najah.cap.advance.assignments.assignment1.new_code.templates;

public class DataProcessingJobTemplate extends HeavyTemplate {

    public DataProcessingJobTemplate(String name, String config, String templateBody) {
        super("DATA", name, config, templateBody);
    }

    @Override
    public JobPrototype clonePrototype() {
        System.out.println("[Prototype] Cloning DataProcessingJobTemplate: " + getName());
        return new DataProcessingJobTemplate(getName(), getConfig(), getTemplateBody());
    }
}
