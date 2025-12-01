package edu.najah.cap.advance.assignments.assignment1.new_code.templates;

public class EmailJobTemplate extends HeavyTemplate {

    public EmailJobTemplate(String name, String config, String templateBody) {
        super("EMAIL", name, config, templateBody);
    }

    @Override
    public JobPrototype clonePrototype() {
        System.out.println("[Prototype] Cloning EmailJobTemplate: " + getName());
        return new EmailJobTemplate(getName(), getConfig(), getTemplateBody());
    }
}
