package edu.najah.cap.advance.assignments.assignment1.new_code.executor;

import edu.najah.cap.advance.assignments.assignment1.new_code.connections.Connection;
import edu.najah.cap.advance.assignments.assignment1.new_code.connections.ConnectionPool;
import edu.najah.cap.advance.assignments.assignment1.new_code.job.Job;
import edu.najah.cap.advance.assignments.assignment1.new_code.model.User;

public class JobExecutorProxy  {

    private final JobExecutor realExecutor;
    private final ConnectionPool connectionPool;

    public JobExecutorProxy(JobExecutor realExecutor, ConnectionPool connectionPool) {
        this.realExecutor = realExecutor;
        this.connectionPool = connectionPool;
    }


    public void executeJob(Job job) {
        User user = job.getRequestedBy();
        String userName = (user == null) ? "unknown" : user.getName();
        String jobType = job.getType();

        System.out.printf("[Proxy] Request to execute job %s (%s) by %s%n",
                job.getName(), jobType, userName);

        // Validate user permissions
        if (user == null || !user.hasPermission(jobType)) {
            System.out.printf("[Proxy] User %s does NOT have permission %s - aborting.%n",
                    userName, jobType);
            return;
        }
        // Log job start/end
        long start = System.currentTimeMillis();

        // Acquire a DB connection from the ConnectionPool
        Connection connection = connectionPool.acquire();

        try {
            System.out.printf("[Proxy] Starting job %s%n", job.getName());
            //  Delegate to the real executor
            realExecutor.execute(job, connection);
        } finally {
            // Release the connection afterward
            connectionPool.release(connection);
            // Log job start/end
            long end = System.currentTimeMillis();
            // Measure execution time
            System.out.printf("[Proxy] Finished job %s in %d ms%n",
                    job.getName(), (end - start));
        }
    }
}
