package com.kim.section.service;

import com.kim.section.mapper.EmpMapper;
import com.kim.section.dto.EmployeeDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.kim.section.Template.getSqlSession;

public class EmpService {

    private EmpMapper empMapper;

    public List<EmployeeDTO> selectAllEmp() {

        SqlSession sqlSession = getSqlSession();

        empMapper = sqlSession.getMapper(EmpMapper.class);

        List<EmployeeDTO> empList = empMapper.selectAllEmp();

        sqlSession.close();

        return empList;
    }

    public EmployeeDTO selectEmpByCode(int empId) {
        SqlSession sqlSession = getSqlSession();
        empMapper = sqlSession.getMapper(EmpMapper.class);
        EmployeeDTO emp = empMapper.selectEmpByCode(empId);
        sqlSession.close();
        return emp;
    }

    public boolean registEmp(EmployeeDTO empDTO) {

        SqlSession sqlSession = getSqlSession();

        empMapper = sqlSession.getMapper(EmpMapper.class);
        int result = empMapper.insertEmp(empDTO);
        if (result > 0){
            sqlSession.commit();;
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0 ? true : false;
    }

    public boolean modifyEmp(EmployeeDTO empDTO) {

        SqlSession sqlSession = getSqlSession();

        empMapper = sqlSession.getMapper(EmpMapper.class);

        int result = empMapper.modifyEmp(empDTO);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean deleteEmp(int empId) {
        SqlSession sqlSession = getSqlSession();

        empMapper = sqlSession.getMapper(EmpMapper.class);

        int result = empMapper.deleteEmp(empId);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
