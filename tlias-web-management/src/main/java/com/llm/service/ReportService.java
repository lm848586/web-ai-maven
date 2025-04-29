package com.llm.service;

import com.llm.pojo.ClazzOption;
import com.llm.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    List<Map> getStudentDegreeData();

    ClazzOption getStudentCountData();
}
