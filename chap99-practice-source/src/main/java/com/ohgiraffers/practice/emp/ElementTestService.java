package com.ohgiraffers.practice.emp;

import com.ohgiraffers.common.DepartmentDTO;
import com.ohgiraffers.common.DeptDTOAndEmpDTO;
import com.ohgiraffers.common.EmpDTOAndDeptDTO;
import com.ohgiraffers.common.EmployeeDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementTestService {

    private ElementTestMapper mapper;

    public void associationTest() {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ElementTestMapper.class);
        List<EmpDTOAndDeptDTO> empList = mapper.associationTest();

        for (EmpDTOAndDeptDTO emp : empList){
            System.out.println(emp);
        }

        sqlSession.close();
    }

    public void collectionTest() {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<DeptDTOAndEmpDTO> deptList = mapper.collectionTest();

//        List<EmployeeDTO> empList = deptList.get(1).getEmpList();
//
//        for (EmployeeDTO emp : empList) {
//            System.out.println(emp.getName()+emp.getPhone());
//        }

        for (DeptDTOAndEmpDTO emp : deptList){
            System.out.println(emp);
        }
        sqlSession.close();
    }
}
