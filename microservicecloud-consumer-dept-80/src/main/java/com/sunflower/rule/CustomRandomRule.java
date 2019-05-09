package com.sunflower.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author: ShiQingFu
 * @description:
 * @date: 2019/5/9 9:28
 */
public class CustomRandomRule extends AbstractLoadBalancerRule {

    private int total = 0;
    private int currentIndex = 0;

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if(lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if(Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if(serverCount == 0) {
                    return null;
                }

                if(total < 5){
                    server = upList.get(currentIndex);
                    total++;
                }else{
                    total = 0;
                    currentIndex++;
                    if(currentIndex >= allList.size()){
                        currentIndex = 0;
                    }
                }

                if(server == null) {
                    Thread.yield();
                } else {
                    if(server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
