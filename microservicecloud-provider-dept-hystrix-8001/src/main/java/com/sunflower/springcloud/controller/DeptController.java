package com.sunflower.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sunflower.springcloud.entities.Dept;
import com.sunflower.springcloud.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "获取部门详细信息",notes = "获取部门详细信息")
    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.get(id);
        if(dept == null){
            throw new RuntimeException("not record");
        }
        return dept;
    }

    public Dept hystrixGet(@PathVariable("id") Long id){
        return Dept.builder().deptno(id).dname("ID: " + id + "的部门不存在--hystrix").dbSource("not database").build();
    }

}
