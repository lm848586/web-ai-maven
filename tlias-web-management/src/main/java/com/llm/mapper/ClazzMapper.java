package com.llm.mapper;

import com.llm.pojo.Clazz;
import com.llm.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(Clazz clazz);

    void deleteById(Integer id);

    Clazz getById(Integer id);

    void update(Clazz clazz);

    List<Clazz> selectAllClazz();
}
