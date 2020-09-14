package com.lht.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author lhtao
 * @date 2020/9/14 14:55
 */
@Component
public class PaymentFallbackService implements FeignHystrixPaymentService{

    @Override
    public String paymentInfoOK(Integer id) {
        return "---PaymentFallbackService fall back paymentInfoOK, o(╥﹏╥)o---";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "---PaymentFallbackService fall back paymentInfoTimeOut, o(╥﹏╥)o---";
    }
}
