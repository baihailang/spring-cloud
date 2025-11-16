package com.baihailang.servicea.controller;

import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ServiceARestController {



    @Resource
    DiscoveryClient discoveryClient;


    @Resource
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world from Service A!";
    }


    @GetMapping("/services")
    public String services() {
        return discoveryClient.getServices().toString();
    }


    @GetMapping("/serviceAInstances")
    public Object serviceAInstances() {
        return discoveryClient.getInstances("serviceA");
    }



    /**
     * 获取服务A实例信息的API接口
     * 该方法主要用于检查serviceB的状态并返回其URL信息
     * 
     * @return 如果serviceB服务状态为UP，则返回serviceB的完整URL；否则返回serviceB的Eureka服务实例对象
     */
    /**
     * 服务间调用代理接口
     * 该方法用于动态调用指定服务的特定URL接口，实现服务间的负载均衡调用
     * 
     * @param serviceName 目标服务名称，用于通过服务发现和负载均衡选择具体实例
     * @param url 目标服务的具体接口路径（不包含服务基础路径）
     * @return 目标服务接口返回的字符串响应
     * @throws RuntimeException 当服务不存在、无法连接或调用失败时抛出异常
     */
    @GetMapping("/serviceUrl/{serviceName}/{url}")
    public String serviceAInstancesInfo(@PathVariable String serviceName, @PathVariable String url) {
        // 使用LoadBalancerClient选择目标服务的一个实例（支持负载均衡）
        // 负载均衡器会根据配置的策略（如轮询、随机等）选择合适的服务实例
        ServiceInstance service = loadBalancerClient.choose(serviceName);
        
        // 使用RestTemplate发起HTTP GET请求到目标服务
        // 构建完整URL：服务实例URI + "/" + 目标接口路径
        // 直接在方法内创建RestTemplate实例（实际应用中建议注入为Bean以提高性能）
        String restr = new RestTemplate().getForObject(service.getUri().toString()+"/"+url, String.class);
        // 返回调用结果
        return restr;
    }
}