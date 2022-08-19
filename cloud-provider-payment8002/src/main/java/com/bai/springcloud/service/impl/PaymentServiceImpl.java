package com.bai.springcloud.service.impl;

import com.bai.springcloud.dao.PaymentDao;
import com.bai.springcloud.entities.Payment;
import com.bai.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SpringCloud
 * @description: 实现类
 * @author: BaiWenHui
 * @create: 2022-07-17 10:39
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }
}
