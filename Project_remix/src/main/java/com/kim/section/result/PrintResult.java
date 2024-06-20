package com.kim.section.result;

import com.kim.section.dto.EmployeeDTO;

import java.util.List;

public class PrintResult {
    public void printEmpList(List<EmployeeDTO> empList) {

        for (EmployeeDTO emp : empList) {
            System.out.println(emp);
        }
    }

    public void printEmp(EmployeeDTO empDTO) {
        System.out.println(empDTO);
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
