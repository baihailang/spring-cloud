package com.baihailang.eurekaserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig  {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // 禁用 CSRF
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().authenticated()  // 所有请求都需要认证
                )
                .httpBasic(Customizer.withDefaults());  // 使用 HTTP Basic 认证

        return http.build();
    }
}
