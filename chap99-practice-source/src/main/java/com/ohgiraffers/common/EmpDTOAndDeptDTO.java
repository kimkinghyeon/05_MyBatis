package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class EmpDTOAndDeptDTO {
    private String empId;
    private String name;
    private String deptCode;
    private DepartmentDTO departmentDTO;
}
