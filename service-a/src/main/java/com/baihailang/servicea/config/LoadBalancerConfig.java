package com.baihailang.servicea.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 负载均衡配置类
 */
@Configuration
public class LoadBalancerConfig {

    // 为 serviceb 配置随机策略
    @LoadBalancerClient(name = "servicea", configuration = RoundConfig.class)
    public static class ServiceAConfig {
    }

    // 为 servicec 配置轮询策略
    @LoadBalancerClient(name = "serviceb", configuration = RandomConfig.class)
    public static class ServiceBConfig {
    }
}

// 随机负载均衡配置
class RandomConfig {

    @Bean
    public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class),name);
    }
}

// 轮询负载均衡配置
class RoundConfig {

    @Bean
    public ReactorLoadBalancer<ServiceInstance> roundRobinLoadBalancer(Environment environment,LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new RoundRobinLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class),name);
    }
}