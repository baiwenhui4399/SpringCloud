package com.bai.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SpringCloud
 * @description:
 * @author: BaiWenHui
 * @create: 2022-07-31 19:29
 */
@Configuration
public class GatewayConfig {

    /**
     * /guonei映射http://news.baidu.com/guonei地址意味着通过网关9527（local:9527/guonei）可以访问这个地址
     *
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_baibai",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
