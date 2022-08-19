package com.bai.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @program: SpringCloud
 * @description:
 * @author: BaiWenHui
 * @create: 2022-07-23 19:04
 */
public interface LoadBalancer {

    //容器加载时，list里面的对象每一个都是装到list

    /**
     * 容器加载时每一个service都要加载到list中
     *
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
