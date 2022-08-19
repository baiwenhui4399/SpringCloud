package com.bai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: SpringCloud
 * @description: openFeign启动类
 * @author: BaiWenHui
 * @create: 2022-07-26 20:13
 */
@SpringBootApplication
@EnableFeignClients
//激活并开启
public class OrderOpenFMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFMain80.class, args);
    }
}
