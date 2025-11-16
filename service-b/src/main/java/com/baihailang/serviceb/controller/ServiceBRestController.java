package com.baihailang.serviceb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class ServiceBRestController {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    @Value("${server.port}")
    private int serverPort;

    public ServiceBRestController(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
        this.discoveryClient = discoveryClient;
        restClient = restClientBuilder.build();
    }

    @GetMapping("helloEureka")
    public String helloWorld() {
        ServiceInstance serviceInstance = discoveryClient.getInstances("servicea").get(0);
        String serviceAResponse = restClient.get()
                .uri(serviceInstance.getUri() + "/helloWorld")
                .retrieve()
                .body(String.class);
        return serviceAResponse;
    }

    @GetMapping("/helloWorld")
    public String helloWorld2() {
        System.out.println("helloWorld serviceB");
        return "helloWorld serviceB port:"+serverPort;
    }
}