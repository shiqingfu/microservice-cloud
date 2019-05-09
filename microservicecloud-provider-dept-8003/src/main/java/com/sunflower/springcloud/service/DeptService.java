package com.sunflower.springcloud.service;

import com.sunflower.springcloud.entities.Dept;

import java.util.List;

/**
 * @author: ShiQingFu
 * @description:
 * @date: 2019/5/7 13:52
 */
public interface DeptService {

    Boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();

}
