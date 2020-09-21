package com.lht.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lht.springcloud.entity.CommonResult;
import com.lht.springcloud.entity.Payment;
import com.lht.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lhtao
 * @date 2020/9/21 14:28
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/fallback/{id}")
    //@SentinelResource(value = "fallback")
    //@SentinelResource(value = "fallback",fallback ="handlerFallback")
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler")  //blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback", fallback ="handlerFallback", blockHandler = "blockHandler") //若blockHandler和fallback都进行了配置，则被限流降级而抛出BlockException时只会进入blockHandler处理逻辑
    //@SentinelResource(value = "fallback", fallback ="handlerFallback", blockHandler = "blockHandler", exceptionsToIgnore = {IllegalArgumentException.class}) //exceptionsToIgnore异常忽略，就算配了fallback也不会进入
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/nacos/payment/paymentSQL/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgument ,非法参数异常...");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }

        return result;
    }


    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "异常handlerFallback，exception内容： " + e.getMessage(), payment);
    }


    public CommonResult blockHandler(@PathVariable Long id, BlockException e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "blockHandler-sentinel 限流，BlockException： " + e.getMessage(), payment);
    }

    //======= OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }

}