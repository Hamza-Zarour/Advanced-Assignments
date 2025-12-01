package edu.najah.cap.advance.assignments.assignment1.new_code.templates;

import edu.najah.cap.advance.assignments.assignment1.new_code.job.Job;


 //Heavy template that simulates Heavy creation.
 //it also acts as a base prototype.

public abstract class HeavyTemplate implements JobPrototype {

    private final String type;
    private final String name;
    private final String config;
    private final String templateBody;

    public HeavyTemplate(String type, String name, String config, String templateBody) {
        this.type = type;
        this.name = name;
        this.config = config;
        this.templateBody = templateBody;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getConfig() {
        return config;
    }

    public String getTemplateBody() {
        return templateBody;
    }

    @Override
    public Job createJobInstance() {
        String id = templateBody + " _ " + type + "-" + System.currentTimeMillis();
        return new Job(id, type, name, config);
    }

}
