package com.sunflower.springcloud.controller;

import com.sunflower.springcloud.entities.Dept;
import com.sunflower.springcloud.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ShiQingFu
 * @description:
 * @date: 2019/5/7 13:54
 */
@Api(description = "部门前端控制器")
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @ApiOperation(value = "新增部门",notes = "新增部门")
    @PostMapping("/add")
    public Boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @ApiOperation(value = "获取部门详细信息",notes = "获取部门详细信息")
    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }

    @ApiOperation(value = "获取部门列表",notes = "获取部门列表")
    @GetMapping("/list")
    public List<Dept> list(){
        return deptService.list();
    }

}
