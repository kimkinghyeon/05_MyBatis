package com.kim.section.mapper;

import com.kim.section.dto.EmployeeDTO;

import java.util.List;

public interface EmpMapper {
    List<EmployeeDTO> selectAllEmp();

    EmployeeDTO selectEmpByCode(int empId);

    int insertEmp(EmployeeDTO empDTO);

    int modifyEmp(EmployeeDTO empDTO);

    int deleteEmp(int empId);
}
