package com.ohgiraffers.common;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class EmpDTOAndDeptDTO {
    private int empId;
    private String name;
    private String no;
    private String email;
    private String phone;
    private String deptCode;
    private DepartmentDTO departmentDTO;
    private String jobCode;
    private String salLevel;
    private double salary;
    private double bonus;
    private String managerId;
    private Date hireDate;
    private Date entDate;
    private String entYn;
}
