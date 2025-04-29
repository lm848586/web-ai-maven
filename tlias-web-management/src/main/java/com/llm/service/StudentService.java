package com.llm.service;

import com.llm.pojo.PageResult;
import com.llm.pojo.Student;
import com.llm.pojo.StudentQueryParam;

import java.util.List;


public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void save(Student student);

    Student getInfo(Integer id);

    void update(Student student);

    void violation(Integer id, Short score);

    void delete(List<Integer> ids);
}
