package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DepartmentDTO {
    private String deptId;
    private String deptTitle;
    private String locationId;
}
