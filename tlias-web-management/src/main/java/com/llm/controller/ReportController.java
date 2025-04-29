package com.llm.controller;

import com.llm.pojo.ClazzOption;
import com.llm.pojo.JobOption;
import com.llm.pojo.Result;
import com.llm.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计员工职位人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别人数");
        List<Map<String,Object>> genderlist = reportService.getEmpGenderData();
        return Result.success(genderlist);
    }

    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("统计学员学历:");
        List<Map> degreelist = reportService.getStudentDegreeData();
        return Result.success(degreelist);
    }

    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("统计班级人数:");
        ClazzOption clazzOption = reportService.getStudentCountData();
        return Result.success(clazzOption);
    }
}
