package com.ohgiraffers.common;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DeptDTOAndEmpDTO {
    private String deptId;
    private String deptTitle;
    private String locationId;

    private List<EmployeeDTO> empList;
}
