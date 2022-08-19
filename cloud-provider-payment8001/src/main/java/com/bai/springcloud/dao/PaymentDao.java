package com.bai.springcloud.dao;

import com.bai.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: SpringCloud
 * @description:
 * @author: BaiWenHui
 * @create: 2022-07-17 10:19
 */
@Mapper
public interface PaymentDao {

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
