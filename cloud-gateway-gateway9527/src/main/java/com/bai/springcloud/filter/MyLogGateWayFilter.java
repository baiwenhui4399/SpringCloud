package com.bai.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @program: SpringCloud
 * @description:
 * @author: BaiWenHui
 * @create: 2022-08-03 10:22
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*******welcome to filter: " + new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null) {
            log.info("*******用户名为null，非法用户，o(╥﹏╥)o，请求不被接受");
            //设置response状态码，返回404，也不会返回错误界面
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);

    }

    /**
     * 返回值是加载顺序，
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
