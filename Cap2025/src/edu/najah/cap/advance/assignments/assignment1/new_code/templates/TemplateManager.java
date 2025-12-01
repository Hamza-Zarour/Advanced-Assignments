package edu.najah.cap.advance.assignments.assignment1.new_code.templates;

import edu.najah.cap.advance.assignments.assignment1.new_code.job.Job;

/*
 * TemplateManager now builds heavy templates ONCE and stores them as prototypes.
 * Later, jobs are created by cloning prototypes via JobTemplateRegistry.
 */
public class TemplateManager {

    private final JobTemplateRegistry registry = new JobTemplateRegistry();

    public void registerEmailTemplate(String key, String templateName, String config) {
        String body = simulateHeavyLoad("EmailTemplate:" + templateName);
        EmailJobTemplate prototype = new EmailJobTemplate(templateName, config, body);
        registry.registerTemplate(key, prototype);
        System.out.println("Registered Email template (prototype): " + templateName);
    }

    public void registerDataProcessingTemplate(String key, String templateName, String config) {
        String body = simulateHeavyLoad("DataTemplate:" + templateName);
        DataProcessingJobTemplate prototype = new DataProcessingJobTemplate(templateName, config, body);
        registry.registerTemplate(key, prototype);
        System.out.println("Registered DataProcessing template (prototype): " + templateName);
    }

    public void registerReportJobTemplate(String key, String templateName, String config) {
        String body = simulateHeavyLoad("ReportTemplate:" + templateName);
        ReportJobTemplate prototype = new ReportJobTemplate(templateName, config, body);
        registry.registerTemplate(key, prototype);
        System.out.println("Registered Report template (prototype): " + templateName);
    }

    public Job createJobFromTemplate(String key) {
        return registry.createJobFromTemplate(key);
    }

    private String simulateHeavyLoad(String msg) {
        System.out.println("Simulating heavy template creation for: " + msg);
        try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        return "Large template";
    }
}
