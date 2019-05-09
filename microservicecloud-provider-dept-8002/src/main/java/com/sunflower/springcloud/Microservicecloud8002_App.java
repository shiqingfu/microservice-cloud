package com.sunflower.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.sunflower.springcloud"})
@MapperScan(value = {"com.sunflower.springcloud.mapper"})
@EnableEurekaClient
public class Microservicecloud8002_App
{
    public static void main( String[] args )
    {
        SpringApplication.run(Microservicecloud8002_App.class,args);
    }
}
