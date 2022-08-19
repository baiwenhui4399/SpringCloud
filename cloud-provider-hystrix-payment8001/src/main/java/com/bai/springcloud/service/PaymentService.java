package com.bai.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @program: SpringCloud
 * @description:
 * @author: BaiWenHui
 * @create: 2022-07-27 19:16
 */
@Service
public class PaymentService {

    /**
     * 正常访问ok
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "" + Thread.currentThread().getName() + "  paymentInfo_OK,id:    " + id + "\t" + "^_^";
    }

    /**
     * 正常访问ok
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")//三秒中以内正常的业务
    })
    public String paymentInfo_Timeout(Integer id) {

//        int time = 3;
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  " + Thread.currentThread().getName() + "  paymentInfo_Timeout,id:    " + id + "\t" + "^_^" + "耗时";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "  paymentInfo_Timeout,id:    " + id + "\t" + "o(╥﹏╥)o出现异常了";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到多少跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") long id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();//产生流水号

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") long id) {
        return "id不能为负数，请稍后再试(#^.^#) id：" + id;
    }
}
