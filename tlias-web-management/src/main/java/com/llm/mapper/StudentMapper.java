package com.llm.mapper;

import com.llm.pojo.Student;
import com.llm.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> list(StudentQueryParam studentQueryParam);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(Student student);

    Student getById(Integer id);

    void update(Student student);

    void updateViolation(Integer id, Short score);

    void delete(List<Integer> ids);

    @MapKey("name")
    List<Map> countStudentDegreeData();

    @MapKey("name")
    List<Map<String, Object>> countStudentCountData();
}
