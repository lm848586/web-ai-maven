package com.llm.controller;

import com.llm.pojo.Emp;
import com.llm.pojo.LoginInfo;
import com.llm.pojo.Result;
import com.llm.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登陆Controller
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;
    /**
     * json格式的数据如果需要封装到实体类,则需要使用@RequestBody注解
     * @param emp
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("登陆: {}",emp);
        LoginInfo info = empService.login(emp);
        if (info != null){
            return Result.success(info);
        }
        return Result.error("用户名或密码错误");
    }

}
