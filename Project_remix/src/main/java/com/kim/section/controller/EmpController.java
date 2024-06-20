package com.kim.section.controller;

import com.kim.section.dto.EmployeeDTO;
import com.kim.section.result.PrintResult;
import com.kim.section.service.EmpService;

import java.util.List;
import java.util.Map;

public class EmpController {

    private final PrintResult printResult;
    private final EmpService empService;

    public EmpController() {
        printResult = new PrintResult();
        empService = new EmpService();
    }

    public void selectAllEmp() {
        List<EmployeeDTO> empList = empService.selectAllEmp();
        if (empList != null) {
            printResult.printEmpList(empList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectEmpByCode(Map<String, String> parameter) {
        int empId = Integer.parseInt(parameter.get("empId"));

        EmployeeDTO emp = empService.selectEmpByCode(empId);

        if (emp != null) {
            printResult.printEmp(emp);
        } else {
            printResult.printErrorMessage("selectOne");
        }

    }

    public void registEmp(Map<String, String> parameter) {

        int empId = Integer.parseInt(parameter.get("empId"));
        String name = parameter.get("name");
        String no = parameter.get("no");
        String jobCode = parameter.get("jobCode");
        int salary = Integer.parseInt(parameter.get("salary"));
        String salLevel = parameter.get("salLevel");

        EmployeeDTO empDTO = new EmployeeDTO();
        empDTO.setEmpId(empId);
        empDTO.setEmpName(name);
        empDTO.setNo(no);
        empDTO.setJobCode(jobCode);
        empDTO.setSalary(salary);
        empDTO.setSalLevel(salLevel);

        if (empService.registEmp(empDTO)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }

    }

    public void modifyEmp(Map<String, String> parameter) {
        int empId = Integer.parseInt(parameter.get("empId"));
        String name = parameter.get("name");
        String jobCode = parameter.get("jobCode");
        String salLevel = parameter.get("salLevel");

        EmployeeDTO empDTO = new EmployeeDTO();
        empDTO.setEmpId(empId);
        empDTO.setEmpName(name);
        empDTO.setJobCode(jobCode);
        empDTO.setSalLevel(salLevel);

        if(empService.modifyEmp(empDTO)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteEmp(Map<String, String> parameter) {

        int empId = Integer.parseInt(parameter.get("empId"));

        if(empService.deleteEmp(empId)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }

    }
}
