package com.lht.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lht.springcloud.entity.Payment;

/**
 * @author lhtao
 * @date 2020/9/2 16:04
 */
public interface PaymentService {

    String paymentInfoOK(Integer id);

    String paymentInfoTimeOut(Integer id);

    String paymentCircuitBreaker(Integer id);
}
