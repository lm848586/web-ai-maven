package com.llm.service;

import com.llm.pojo.Emp;
import com.llm.pojo.EmpQueryParam;
import com.llm.pojo.LoginInfo;
import com.llm.pojo.PageResult;

import java.util.List;

public interface EmpService {

    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    List<Emp> selectAllEmp();

    LoginInfo login(Emp emp);
    //PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
}
