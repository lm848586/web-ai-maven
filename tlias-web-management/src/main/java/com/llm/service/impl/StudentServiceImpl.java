package com.llm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.llm.mapper.StudentMapper;
import com.llm.pojo.PageResult;
import com.llm.pojo.Student;
import com.llm.pojo.StudentQueryParam;
import com.llm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());

        List<Student> studentList = studentMapper.list(studentQueryParam);

        Page<Student> p = (Page<Student>) studentList;
        return new PageResult<Student>(p.getTotal(),p.getResult());
    }

    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void violation(Integer id, Short score) {
        studentMapper.updateViolation(id,score);
    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.delete(ids);
    }


}
