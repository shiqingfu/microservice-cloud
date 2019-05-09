package com.sunflower.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ShiQingFu
 * @description:
 * @date: 2019/5/8 17:57
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule rule(){
//        return new RandomRule();
//        return new RetryRule();
        return new CustomRandomRule();
    }

}
