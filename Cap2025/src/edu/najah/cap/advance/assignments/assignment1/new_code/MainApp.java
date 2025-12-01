package edu.najah.cap.advance.assignments.assignment1.new_code;

import edu.najah.cap.advance.assignments.assignment1.new_code.connections.ConnectionPool;
import edu.najah.cap.advance.assignments.assignment1.new_code.executor.JobExecutor;
import edu.najah.cap.advance.assignments.assignment1.new_code.executor.JobExecutorProxy;
import edu.najah.cap.advance.assignments.assignment1.new_code.job.Job;
import edu.najah.cap.advance.assignments.assignment1.new_code.model.User;
import edu.najah.cap.advance.assignments.assignment1.new_code.templates.TemplateManager;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== TMPS Refactored (clean new_code) ===");

        // 1) Template Manager + Connection Pool
        ConnectionPool connectionPool = new ConnectionPool();
        TemplateManager templateManager = new TemplateManager();

        //  2) Register templates
        templateManager.registerReportJobTemplate(
                "REPORT_MONTHLY",
                "MonthlyReport",
                "format=PDF;brand=TaskMaster"
        );
        templateManager.registerEmailTemplate(
                "EMAIL_MONTHLY",
                "Monthly email Report",
                "format=PDF;all=true"
        );

        // 3) Executor + Proxy
        JobExecutor realExecutor = new JobExecutor();
        JobExecutorProxy executor = new JobExecutorProxy(realExecutor, connectionPool);

        User alice = new User("alice", Arrays.asList("EMAIL", "REPORT"));

        System.out.println("\n--- Create Report Job from prototype ---");
        Job reportJob = templateManager.createJobFromTemplate("REPORT_MONTHLY");
        reportJob.setRequestedBy(alice);

        System.out.println("\n--- Execute job (via Proxy) ---");
        executor.executeJob(reportJob);

        System.out.println("\n--- Create Email Job from prototype ---");
        Job emailJob = templateManager.createJobFromTemplate("EMAIL_MONTHLY");
        emailJob.setRequestedBy(alice);

        System.out.println("\n--- Execute job (via Proxy) ---");
        executor.executeJob(emailJob);
    }
}
