package com.llm.aop;

import com.llm.mapper.OperateLogMapper;
import com.llm.pojo.OperateLog;
import com.llm.utils.CurrentHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.llm.anno.Log)")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;

        OperateLog log = new OperateLog();
        log.setOperateEmpId(getCurrentUserId());
        log.setOperateTime(LocalDateTime.now());
        log.setClassName(joinPoint.getTarget().getClass().getName());
        log.setMethodName(joinPoint.getSignature().getName());
        log.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        log.setReturnValue(result != null ? result.toString() : "void");
        log.setCostTime(costTime);

        operateLogMapper.insert(log);
        return result;
    }
    public Integer getCurrentUserId(){
        return CurrentHolder.getCurrentId();
    }
}
