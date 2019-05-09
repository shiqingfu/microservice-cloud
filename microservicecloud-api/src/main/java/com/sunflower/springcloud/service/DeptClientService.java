package com.sunflower.springcloud.service;

import com.sunflower.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ShiQingFu
 * @description:
 * @date: 2019/5/9 10:02
 */
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
@RequestMapping("/dept")
public interface DeptClientService {

    @PostMapping("/add")
    Boolean add(@RequestBody Dept dept);

    @GetMapping("/get/{id}")
    Dept get(@PathVariable("id") Long id);

    @GetMapping("/list")
    List<Dept> list();

}
