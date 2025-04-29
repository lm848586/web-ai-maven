package com.llm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.llm.mapper.OperateLogMapper;
import com.llm.pojo.LogQueryParam;
import com.llm.pojo.OperateLog;
import com.llm.pojo.PageResult;
import com.llm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private OperateLogMapper operateLogMapper;
    @Override
    public PageResult<OperateLog> page(LogQueryParam logQueryParam) {
        PageHelper.startPage(logQueryParam.getPage(),logQueryParam.getPageSize());

        List<OperateLog> logList = operateLogMapper.list(logQueryParam);

        Page<OperateLog> page = (Page<OperateLog>) logList;
        return new PageResult<OperateLog>(page.getTotal(),page.getResult());
    }
}
