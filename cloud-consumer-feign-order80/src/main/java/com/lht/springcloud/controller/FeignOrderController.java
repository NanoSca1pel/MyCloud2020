package com.lht.springcloud.controller;

import com.lht.springcloud.entity.CommonResult;
import com.lht.springcloud.entity.Payment;
import com.lht.springcloud.service.FeignPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lhtao
 * @date 2020/9/10 17:35
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class FeignOrderController {

    @Autowired
    private FeignPaymentService feignPaymentService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        return feignPaymentService.getById(id);
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        //openfeign-ribbon, 客户端一般默认等待1秒钟
        return feignPaymentService.paymentFeignTimeout();
    }
}
