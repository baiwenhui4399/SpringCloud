package com.bai.springcloud.service;

import com.bai.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;


public interface PaymentService {

    /**
     * 创建流水记录
     *
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 通过id获得流水记录
     *
     * @param id
     * @return 流水类
     */
    public Payment getPaymentById(@Param("id") long id);
}
