package com.lht.springcloud.service;

import com.lht.springcloud.entity.CommonResult;
import com.lht.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lhtao
 * @date 2020/9/10 17:27
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")  //此处微服务名大小写不影响
public interface FeignPaymentService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}
