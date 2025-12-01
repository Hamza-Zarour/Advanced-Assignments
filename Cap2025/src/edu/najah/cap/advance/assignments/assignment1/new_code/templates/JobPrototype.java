package edu.najah.cap.advance.assignments.assignment1.new_code.templates;

import edu.najah.cap.advance.assignments.assignment1.new_code.job.Job;

public interface JobPrototype {

    Job createJobInstance();

    JobPrototype clonePrototype();
}
