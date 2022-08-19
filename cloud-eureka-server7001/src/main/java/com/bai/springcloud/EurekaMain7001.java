package com.bai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: SpringCloud
 * @description: Eureka
 * @author: BaiWenHui
 * @create: 2022-07-17 19:33
 */
@SpringBootApplication
@EnableEurekaServer
//表明这个就是服务注册中心
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
