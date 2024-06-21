package com.kim.section.controller;

import com.kim.section.dto.JobDTO;
import com.kim.section.result.JobPrintResult;
import com.kim.section.service.JobService;

import java.util.List;

public class JobController {

    private final JobPrintResult jobprintResult;
    private final JobService jobService;

    public JobController() {
        jobprintResult = new JobPrintResult();
        jobService = new JobService();
    }

    public void selectAllJob() {
        List<JobDTO> jobList = jobService.selectAllJob();
        if (jobList != null) {
            jobprintResult.printJobList(jobList);
        } else {
            jobprintResult.printErrorMessage("selectList");
        }
    }

}
