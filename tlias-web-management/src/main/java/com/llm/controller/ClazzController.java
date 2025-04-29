package com.llm.controller;

import com.llm.anno.Log;
import com.llm.pojo.Clazz;
import com.llm.pojo.ClazzQueryParam;
import com.llm.pojo.PageResult;
import com.llm.pojo.Result;
import com.llm.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam){
     log.info("分页查询: {}",clazzQueryParam);
     PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
     return Result.success(pageResult);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("当前删除的班级id为:{}",id);
        clazzService.deleteById(id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        log.info("新增班级: {}",clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询班级信息: {}",id);
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级: {}",clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    @GetMapping("/list")
    public Result selectAll(){
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.selectAllClazz();
        return Result.success(clazzList);
    }
}
