package com.bai.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: SpringCloud
 * @description: RestTemplate配置类
 * @author: BaiWenHui
 * @create: 2022-07-17 17:18
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced 负载均衡的话要加
    //富裕restTemplate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
