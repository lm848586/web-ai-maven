package com.llm.mapper;

import com.llm.pojo.LogQueryParam;
import com.llm.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OperateLogMapper {

    //插入日志数据
    @Insert("insert into operate_log (operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values (#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime});")
    public void insert(OperateLog log);

    @Select("select operate_emp_id , operate_time, class_name, method_name, method_params, return_value, cost_time, e.name operateEmpName " +
            "from operate_log o join emp e on o.operate_emp_id = e.id " +
            "order by operate_time desc ")
    List<OperateLog> list(LogQueryParam logQueryParam);
}