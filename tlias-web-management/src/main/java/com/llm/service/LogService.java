package com.llm.service;

import com.llm.pojo.LogQueryParam;
import com.llm.pojo.OperateLog;
import com.llm.pojo.PageResult;

public interface LogService {
    PageResult<OperateLog> page(LogQueryParam logQueryParam);
}
