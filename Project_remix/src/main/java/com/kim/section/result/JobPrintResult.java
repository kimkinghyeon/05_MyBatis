package com.kim.section.result;

import com.kim.section.dto.JobDTO;

import java.util.List;

public class JobPrintResult {
    public void printJobList(List<JobDTO> jobList) {

        for (JobDTO job : jobList) {
            System.out.println(job);
        }
    }

    public void printJob(JobDTO jobDTO) {
        System.out.println(jobDTO);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode) {
            case "selectList":
                errorMessage = "메뉴 목록 조회를 실패했습니다.";
                break;
            case "selectOne":
                errorMessage = "메뉴 조회를 실패했습니다.";
                break;
            case "insert":
                errorMessage = "신규 메뉴 등록을 실패했습니다.";
                break;
            case "update":
                errorMessage = "메뉴 수정을 실패했습니다.";
                break;
            case "delete":
                errorMessage = "메뉴 삭제를 실패했습니다.";
                break;
        }
        System.out.println(errorMessage);
    }

    public void printSuccessMessage(String sueccessCode){
        String sueccessMessage = "";
        switch (sueccessCode) {
            case "insert": sueccessMessage = "신규 메뉴 등록을 성공했습니다.";
                break;
            case "update": sueccessMessage = "메뉴 수정을 성공했습니다.";
                break;
            case "delete": sueccessMessage = "메뉴 삭제를 성공했습니다.";
                break;
        }
        System.out.println(sueccessMessage);
    }
}
