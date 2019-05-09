package com.sunflower.springcloud.service;

import com.sunflower.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: ShiQingFu
 * @description:
 * @date: 2019/5/9 14:30
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Boolean add(Dept dept) {
                return null;
            }

            @Override
            public Dept get(Long id) {
                return Dept.builder().deptno(id).dname("该ID：" + id + "没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .dbSource("no this database in MySQL").build();
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
