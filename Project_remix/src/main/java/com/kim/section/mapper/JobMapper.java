package com.kim.section.mapper;

import com.kim.section.dto.JobDTO;

import java.util.List;

public interface JobMapper {
    List<JobDTO> selectAllJob();
}
