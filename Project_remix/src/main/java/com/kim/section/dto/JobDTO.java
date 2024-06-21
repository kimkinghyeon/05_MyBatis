package com.kim.section.dto;

public class JobDTO {
    private String jobName;
    private String jobCode;

    public JobDTO() {
    }

    public JobDTO(String jobName, String jobCode) {
        this.jobName = jobName;
        this.jobCode = jobCode;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    @Override
    public String toString() {
        return "JobDTO{" +
                "jobName='" + jobName + '\'' +
                ", jobCode='" + jobCode + '\'' +
                '}';
    }
}
