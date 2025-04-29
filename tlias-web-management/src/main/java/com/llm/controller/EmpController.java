package com.llm.controller;

import com.llm.anno.Log;
import com.llm.pojo.Emp;
import com.llm.pojo.EmpQueryParam;
import com.llm.pojo.PageResult;
import com.llm.pojo.Result;
import com.llm.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize,
//                       String name, Integer gender,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
//        log.info("分页查询: {},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
//        PageResult<Emp> pageResult = empService.page(page, pageSize, name, gender, begin, end);
//        return Result.success(pageResult);
//    }

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询: {}",empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    @Log
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工: {}", emp);
        empService.save(emp);
        return Result.success();
    }

    @Log
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除员工 : {}",ids);
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据Id查询员工信息: {}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工: {}",emp);
        empService.update(emp);
        return Result.success();
    }

    @GetMapping("/list")
    public Result selectAll(){
        log.info("查询全部员工");
        List<Emp> empList = empService.selectAllEmp();
        return Result.success(empList);
    }

}
