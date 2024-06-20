package com.kim.section;

import com.kim.section.controller.EmpController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmpController empController = new EmpController();

        do {
            System.out.println("==== 오지라퍼 직원관리 ====");
            System.out.println("1. 직원 전체조회");
            System.out.println("2. 직원 조회");
            System.out.println("3. 신규 직원등록");
            System.out.println("4. 직원 정보 수정");
            System.out.println("5. 직원 정보 삭제");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    empController.selectAllEmp();
                    break;
                case 2:
                    empController.selectEmpByCode(inputEmpCode());
                    break;
                case 3:
                    empController.registEmp(inputEmp());
                    break;
                case 4:
                    empController.modifyEmp(inputModifyEmp());
                    break;
                case 5:
                    empController.deleteEmp(inputEmpCode());
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("입력 하나 못하는 흑우없제");
                    break;
            }

        } while (true);
    }
    private static Map<String, String> inputEmpCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("직원 코드를 입력하세요 : ");
        String empId =sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("empId",empId );

        return parameter;
    }

    // 직원 정보를 입력받는 메서드
    private static Map<String, String> inputEmp() {
        Scanner sc = new Scanner(System.in);
        System.out.print("직원의 사원번호를 입력하세요 : ");
        String empId = sc.nextLine();
        System.out.print("직원 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("직원 생년을 입력하세요 : ");
        String no = sc.nextLine();
        System.out.print("직원 잡코드를 입력하세요 : ");
        String jobCode = sc.nextLine();
        System.out.print("직원의 급여를 입력하세요 : ");
        String salary = sc.nextLine();
        System.out.print("급여 등급을 입력하세요 : ");
        String salLevel = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("empId",empId);
        parameter.put("name", name);
        parameter.put("no",no);
        parameter.put("jobCode", jobCode);
        parameter.put("salary",salary);
        parameter.put("salLevel", salLevel);
        return parameter;
    }

    // 수정할 직원 정보를 입력하는 메서드
    private static Map<String, String> inputModifyEmp() {
        Scanner sc = new Scanner(System.in);

        System.out.print("수정할 직원 코드를 입력하세요 : ");
        String empId = sc.nextLine();
        System.out.print("수정할 직원 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("수정할 직원 잡코드를 입력하세요 : ");
        String jobCode = sc.nextLine();
        System.out.print("수정할 급여등급 코드를 입력하세요 : ");
        String salLevel = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("empId", empId);
        parameter.put("name", name);
        parameter.put("jobCode", jobCode);
        parameter.put("salLevel", salLevel);

        return parameter;
    }
}
