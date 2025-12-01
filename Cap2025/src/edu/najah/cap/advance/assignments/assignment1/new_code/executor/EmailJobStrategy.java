package edu.najah.cap.advance.assignments.assignment1.new_code.executor;

import edu.najah.cap.advance.assignments.assignment1.new_code.connections.Connection;
import edu.najah.cap.advance.assignments.assignment1.new_code.job.Job;

public class EmailJobStrategy implements JobStrategy {

    @Override
    public void execute(Job job, Connection connection) {
        System.out.println("[EmailJob] Preparing to send email using config: " + job.getConfig());
        connection.executeQuery(
                "INSERT INTO email_sent (job, status) VALUES ('" + job.getId() + "', 'SENT')"
        );

    }
}
