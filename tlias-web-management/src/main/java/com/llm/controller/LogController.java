package com.llm.controller;

import com.llm.pojo.LogQueryParam;
import com.llm.pojo.OperateLog;
import com.llm.pojo.PageResult;
import com.llm.pojo.Result;
import com.llm.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/page")
    public Result page(LogQueryParam logQueryParam){
      log.info("分页查询 : {}",logQueryParam);
      PageResult<OperateLog> pageResult = logService.page(logQueryParam);
      return Result.success(pageResult);
    }
}
