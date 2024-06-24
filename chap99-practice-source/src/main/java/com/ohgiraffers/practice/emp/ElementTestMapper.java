package com.ohgiraffers.practice.emp;

import com.ohgiraffers.common.DeptDTOAndEmpDTO;
import com.ohgiraffers.common.EmpDTOAndDeptDTO;

import java.util.List;

public interface ElementTestMapper {
    List<EmpDTOAndDeptDTO> associationTest();

    List<DeptDTOAndEmpDTO> collectionTest();
}
