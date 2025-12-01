package edu.najah.cap.advance.assignments.assignment1.new_code.executor;

import edu.najah.cap.advance.assignments.assignment1.new_code.connections.Connection;
import edu.najah.cap.advance.assignments.assignment1.new_code.job.Job;

public interface JobStrategy {

    void execute(Job job, Connection connection);
}
