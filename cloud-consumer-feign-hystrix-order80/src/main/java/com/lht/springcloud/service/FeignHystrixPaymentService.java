package com.lht.springcloud.service;

import com.lht.springcloud.entity.CommonResult;
import com.lht.springcloud.entity.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lhtao
 * @date 2020/9/10 17:27
 */
@Component
@FeignClient(value = "HYSTRIX-CLOUD-PROVIDER-PAYMENT", fallback = PaymentFallbackService.class)  //此处微服务名大小写不影响, 如果针对每个方法配置了单独的fallback方法，可以不需要配fallback全局类
public interface FeignHystrixPaymentService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfoOK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id);
}
