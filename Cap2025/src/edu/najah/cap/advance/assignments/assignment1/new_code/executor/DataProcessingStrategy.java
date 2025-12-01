package edu.najah.cap.advance.assignments.assignment1.new_code.executor;

import edu.najah.cap.advance.assignments.assignment1.new_code.connections.Connection;
import edu.najah.cap.advance.assignments.assignment1.new_code.job.Job;

public class DataProcessingStrategy implements JobStrategy {

    @Override
    public void execute(Job job, Connection connection) {
        System.out.println("[DataJob] Reading & transforming data using config: " + job.getConfig());
        connection.executeQuery(
                "SELECT * FROM source_table WHERE job_id = '" + job.getId() + "'"
        );
        connection.executeQuery(
                "INSERT INTO processed_results (job_id) VALUES ('" + job.getId() + "')"
        );
    }
}
