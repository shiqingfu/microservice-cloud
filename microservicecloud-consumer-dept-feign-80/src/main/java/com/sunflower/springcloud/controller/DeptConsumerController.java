package com.sunflower.springcloud.controller;

import com.sunflower.springcloud.entities.Dept;
import com.sunflower.springcloud.service.DeptClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ShiQingFu
 * @description:
 * @date: 2019/5/7 14:34
 */
@Api(description = "消费端Feign部门前端控制器")
@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService;

    @ApiOperation(value = "消费端新增部门信息",notes = "消费端新增部门信息")
    @PostMapping("/add")
    public Boolean add(@RequestBody Dept dept){
        return deptClientService.add(dept);
    }

    @ApiOperation(value = "消费端获取部门详情")
    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptClientService.get(id);
    }

    @ApiOperation(value = "消费端获取部门列表",notes = "消费端获取部门列表")
    @GetMapping("/list")
    public List<Dept> list(){
        return deptClientService.list();
    }

}
