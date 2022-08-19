package com.bai.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SpringCloud
 * @description:
 * @author: BaiWenHui
 * @create: 2022-07-20 10:53
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();//随机
    }
}
