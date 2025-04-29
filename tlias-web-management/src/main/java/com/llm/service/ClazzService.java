package com.llm.service;

import com.llm.pojo.Clazz;
import com.llm.pojo.ClazzQueryParam;
import com.llm.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    void save(Clazz clazz);

    void deleteById(Integer id);

    Clazz getInfo(Integer id);

    void update(Clazz clazz);

    List<Clazz> selectAllClazz();
}
