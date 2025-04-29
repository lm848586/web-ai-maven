package com.llm.controller;

import com.llm.anno.Log;
import com.llm.pojo.Dept;
import com.llm.pojo.Result;
import com.llm.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //@RequestMapping(value = "/depts",method = RequestMethod.GET)//method指定请求方式
    @GetMapping
    public Result list(){
        log.info("查询数据...");
        System.out.println("查询全部数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    //删除部门
    //方式一:
    //    @DeleteMapping("/depts")
    //    public Result delete(HttpServletRequest request){
    //        String idStr = request.getParameter("id");
    //        int id = Integer.parseInt(idStr);
    //        System.out.println("根据id删除部门:" + id);
    //        return Result.success();
    //    }

    //方式二:
    //    @DeleteMapping("/depts")
    //    public Result delete(@RequestParam("id") Integer deptId){
    //        System.out.println("根据id删除部门:" + deptId);
    //        return Result.success();
    //    }

    //方式三:省略@RequestParam(前端传递的请求参数名与服务端方法形参相同)
    @Log
    @DeleteMapping
    public Result delete(Integer id){
        log.info("当前删除的id为:{}",id);
        System.out.println("根据id删除部门:" + id);
        deptService.deleteById(id);
        return Result.success();
    }

    //新增部门
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        System.out.println("新增部门: " + dept);
        deptService.add(dept);
        return Result.success();

    }

    //查询部门
    //    @GetMapping("/depts/{id}")
    //    public Result getInfo(@PathVariable("id") Integer deptId){
    //        System.out.println("根据id查询部门: " + deptId);
    //        return Result.success();
    //    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        System.out.println("根据id查询部门: " + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    //修改部门
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        System.out.println("修改部门: "+ dept);
        deptService.update(dept);
        return Result.success();
    }
}
