package com.lht.springcloud.service;

import com.lht.springcloud.entity.CommonResult;
import com.lht.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author lhtao
 * @date 2020/9/21 14:27
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回，---PaymentFallbackService",new Payment(id,"ErrorSerial"));
    }
}
