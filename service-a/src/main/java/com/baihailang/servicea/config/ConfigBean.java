package com.baihailang.servicea.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类，用于定义Bean
 */
@Configuration
public class ConfigBean {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
