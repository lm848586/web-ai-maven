package com.llm.controller;

import com.llm.anno.Log;
import com.llm.pojo.PageResult;
import com.llm.pojo.Result;
import com.llm.pojo.Student;
import com.llm.pojo.StudentQueryParam;
import com.llm.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        log.info("查询列表: {}",studentQueryParam);
        PageResult<Student> studentPage = studentService.page(studentQueryParam);
        return Result.success(studentPage);
    }

    @Log
    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("添加员工: {}",student);
        studentService.save(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询学员信息: {}",id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学员信息: {}",student);
        studentService.update(student);
        return Result.success();
    }

    @Log
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id,@PathVariable Short score){
        log.info("违纪员工修改参数 : {},{}",id,score);
        studentService.violation(id,score);
        return Result.success();
    }

    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除学员: {}",ids);
        studentService.delete(ids);
        return Result.success();
    }
}
