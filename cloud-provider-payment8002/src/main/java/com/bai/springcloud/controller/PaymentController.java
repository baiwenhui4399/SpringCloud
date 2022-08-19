package com.bai.springcloud.controller;

import com.bai.springcloud.entities.CommonResult;
import com.bai.springcloud.entities.Payment;
import com.bai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @program: SpringCloud
 * @description: payment
 * @author: BaiWenHui
 * @create: 2022-07-17 10:47
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入成功!,serverPort" + serverPort, result);
        } else {
            return new CommonResult(444, "插入失败!", result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果：" + payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询id：" + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
