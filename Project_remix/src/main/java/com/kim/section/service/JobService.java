package com.kim.section.service;



import com.kim.section.dto.JobDTO;

import com.kim.section.mapper.EmpMapper;
import com.kim.section.mapper.JobMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.kim.section.JobTemplate.getJobSqlSession;
import static com.kim.section.Template.getSqlSession;


public class JobService {

    private static JobMapper jobMapper;

    public List<JobDTO> selectAllJob() {

        SqlSession sqlSession = getJobSqlSession();

        jobMapper = sqlSession.getMapper(JobMapper.class);

        List<JobDTO> jobList = jobMapper.selectAllJob();

        sqlSession.close();

        return jobList;
    }

    public JobDTO selectJobByCode(String jobCode) {
        SqlSession sqlSession = getJobSqlSession();
        jobMapper = sqlSession.getMapper(JobMapper.class);
        JobDTO job = jobMapper.selectJobByCode(jobCode);
        sqlSession.close();
        return job;
    }


    public boolean registJob(String jobCode) {
        SqlSession sqlSession = getJobSqlSession();

        jobMapper = sqlSession.getMapper(JobMapper.class);
        int result = jobMapper.insertJob(jobCode);
        if (result > 0){
            sqlSession.commit();;
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0 ? true : false;
    }

    public boolean modifyJob(JobDTO jobDTO) {
        SqlSession sqlSession = getJobSqlSession();

        jobMapper = sqlSession.getMapper(JobMapper.class);

        int result = jobMapper.modifyJob(jobDTO);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;

    }

    public boolean deleteJob(String jobCode) {
        SqlSession sqlSession = getJobSqlSession();

        jobMapper = sqlSession.getMapper(JobMapper.class);

        int result = jobMapper.deleteJob(jobCode);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
