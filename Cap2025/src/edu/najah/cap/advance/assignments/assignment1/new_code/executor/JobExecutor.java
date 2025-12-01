package edu.najah.cap.advance.assignments.assignment1.new_code.executor;

import edu.najah.cap.advance.assignments.assignment1.new_code.connections.Connection;
import edu.najah.cap.advance.assignments.assignment1.new_code.job.Job;

public class JobExecutor {

    private final JobStrategyFactory strategyFactory;

    public JobExecutor() {
        this.strategyFactory = new JobStrategyFactory();
    }

    public void execute(Job job, Connection connection) {
        JobStrategy strategy = strategyFactory.getStrategy(job.getType());
        strategy.execute(job, connection);
    }
}
