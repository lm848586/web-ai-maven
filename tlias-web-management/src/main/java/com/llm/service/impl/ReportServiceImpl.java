package com.llm.service.impl;

import com.llm.mapper.EmpMapper;
import com.llm.mapper.StudentMapper;
import com.llm.pojo.ClazzOption;
import com.llm.pojo.JobOption;
import com.llm.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public JobOption getEmpJobData() {
        //1.调用Mapper接口,获取统计数据
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        //2.组装结果,并返回
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(jobList,dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map> getStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }

    @Override
    public ClazzOption getStudentCountData() {
        List<Map<String,Object>> countlist = studentMapper.countStudentCountData();
        List<Object> clazzList = countlist.stream().map(map -> map.get("cname")).toList();
        List<Object> dataList = countlist.stream().map(map -> map.get("scount")).toList();
        return new ClazzOption(clazzList,dataList);
    }
}
