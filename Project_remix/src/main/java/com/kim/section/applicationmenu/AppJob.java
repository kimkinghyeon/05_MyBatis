package com.kim.section.applicationmenu;

import com.kim.section.controller.JobController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppJob {
    public static void AppJobList() {
        JobController jobController = new JobController();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("==== 오지라퍼 직급관리 ====");
            System.out.println("1. 직급 전체조회");
            System.out.println("2. 직급 조회");
            System.out.println("3. 신규 직급등록");
            System.out.println("4. 직급 정보 수정");
            System.out.println("5. 직급 정보 삭제");
            System.out.println("6. 이전페이지");
            System.out.print("수행할 번호를 입력하세요 : ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    jobController.selectAllJob();
                    break;
                case 2:
                    jobController.selectJobByCode(inputJobCode());
                    break;
                case 3:
                    jobController.registJob(inputJob());
                    break;
                case 4:
                    jobController.modifyJob(inputModifyJob());
                    break;
                case 5:
                    jobController.deleteJob(inputJobCode());
                    break;
                case 6:
                    System.out.println("오지라퍼 직원관리");
                    return;
                default:
                    System.out.println("입력 하나 못하는 흑우없제");
                    break;
            }

        } while (true);
    }

    private static Map<String, String> inputJobCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("직급 코드를 입력하세요 : ");
        String jobCode =sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("jobCode",jobCode );

        return parameter;

    }

    private static Map<String,String> inputJob() {

        Scanner sc = new Scanner(System.in);
        System.out.print("직급 코드를 입력하세요 : ");
        String jobCode = sc.nextLine();
        System.out.print("직급을 입력하세요 : ");
        String jobName = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("jobCode",jobCode);
        parameter.put("jobName",jobName);

        return parameter;
    }

    private static Map<String, String> inputModifyJob() {
        Scanner sc = new Scanner(System.in);

        System.out.print("수정할 직급코드를 입력하세요 : ");
        String jobCode = sc.nextLine();
        System.out.print("수정할 직급 이름을 입력하세요 : ");
        String jobName = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("jobCode", jobCode);
        parameter.put("jobName", jobName);

        return parameter;
    }
}
