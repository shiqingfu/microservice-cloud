package com.sunflower.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: ShiQingFu
 * @description:
 * @date: 2019/5/9 15:26
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableHystrixDashboard
public class DeptConsumer9001_Dashboard_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer9001_Dashboard_App.class,args);
    }

}
