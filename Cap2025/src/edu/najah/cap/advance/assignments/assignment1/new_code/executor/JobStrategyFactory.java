package edu.najah.cap.advance.assignments.assignment1.new_code.executor;

public class JobStrategyFactory {

    public JobStrategy getStrategy(String jobType) {
        if (jobType == null) {
            throw new IllegalArgumentException("Job type cannot be null");
        }
        switch (jobType.toUpperCase()) {
            case "EMAIL":
                return new EmailJobStrategy();
            case "DATA":
                return new DataProcessingStrategy();
            case "REPORT":
                return new ReportGenerationStrategy();
            default:
                throw new IllegalArgumentException("Unknown job type: " + jobType);
        }
    }
}
