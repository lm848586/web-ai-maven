package com.llm.service;

import com.llm.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
