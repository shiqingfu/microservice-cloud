package com.sunflower.springcloud.service.impl;

import com.sunflower.springcloud.entities.Dept;
import com.sunflower.springcloud.mapper.DeptMapper;
import com.sunflower.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ShiQingFu
 * @description:
 * @date: 2019/5/7 13:53
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Boolean add(Dept dept) {
        return deptMapper.insert(dept) > 0 ? true : false;
    }

    @Override
    public Dept get(Long id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dept> list() {
        return deptMapper.selectByExample(null);
    }
}
