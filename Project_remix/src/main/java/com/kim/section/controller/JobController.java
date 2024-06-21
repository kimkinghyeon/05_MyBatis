package com.kim.section.controller;

import com.kim.section.dto.EmployeeDTO;
import com.kim.section.dto.JobDTO;
import com.kim.section.result.JobPrintResult;
import com.kim.section.service.JobService;

import java.util.List;
import java.util.Map;

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

    public void selectJobByCode(Map<String, String> parameter) {
        String  jobCode = parameter.get("jobCode");

        JobDTO job = jobService.selectJobByCode(jobCode);

        if (job != null) {
            jobprintResult.printJob(job);
        } else {
            jobprintResult.printErrorMessage("selectOne");
        }
    }

    public void registJob(Map<String, String> parameter) {


        String name = parameter.get("name");
        String jobCode = parameter.get("jobCode");


        JobDTO jobDTO = new JobDTO();

        jobDTO.setJobName(name);
        jobDTO.setJobCode(jobCode);


        if (jobService.registJob(jobCode)) {
            jobprintResult.printSuccessMessage("insert");
        } else {
            jobprintResult.printErrorMessage("insert");
        }


    }
}
