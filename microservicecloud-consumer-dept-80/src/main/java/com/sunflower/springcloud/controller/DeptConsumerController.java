package com.sunflower.springcloud.controller;

import com.sunflower.springcloud.entities.Dept;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: ShiQingFu
 * @description:
 * @date: 2019/5/7 14:34
 */
@Api(description = "消费端部门前端控制器")
@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

//    private static final String REST_URL_PREFIX = "http://127.0.0.1:8001";
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "消费端新增部门信息",notes = "消费端新增部门信息")
    @PostMapping("/add")
    public Boolean add(@RequestBody Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }

    @ApiOperation(value = "消费端获取部门详情")
    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id,Dept.class);
    }

    @ApiOperation(value = "消费端获取部门列表",notes = "消费端获取部门列表")
    @GetMapping("/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list",List.class);
    }

}
