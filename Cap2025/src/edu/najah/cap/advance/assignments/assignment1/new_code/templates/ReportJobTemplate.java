package edu.najah.cap.advance.assignments.assignment1.new_code.templates;

public class ReportJobTemplate extends HeavyTemplate {

    public ReportJobTemplate(String name, String config, String templateBody) {
        super("REPORT", name, config, templateBody);
    }

    @Override
    public JobPrototype clonePrototype() {
        System.out.println("[Prototype] Cloning ReportJobTemplate: " + getName());
        return new ReportJobTemplate(getName(), getConfig(), getTemplateBody());
    }
}
