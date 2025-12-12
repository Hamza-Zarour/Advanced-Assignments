package edu.najah.cap.advance.assignments.assignment1.new_code.templates;

import edu.najah.cap.advance.assignments.assignment1.new_code.job.Job;

import java.util.HashMap;
import java.util.Map;

public class JobTemplateRegistry {

    private final Map<String, JobPrototype> prototypes = new HashMap<>();

    public void registerTemplate(String key, JobPrototype prototype) {
        prototypes.put(key, prototype);
    }

    public JobPrototype getPrototype(String key) {
        JobPrototype prototype = prototypes.get(key);
        if (prototype == null) {
            throw new IllegalArgumentException("No prototype registered for key: " + key);
        }
        return prototype;
    }

    public Job createJobFromTemplate(String key) {
        JobPrototype original = getPrototype(key);
        JobPrototype clone = original.clonePrototype();// بنعمل نسخة عنه بالكلون
        return clone.createJobInstance();
    }
}
