package com.lht.springcloud.controller;

import com.lht.springcloud.entity.CommonResult;
import com.lht.springcloud.entity.Payment;
import com.lht.springcloud.service.FeignHystrixPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@RequestMapping("/consumer/hystrix")
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
@Slf4j
public class FeignHystrixOrderController {

    @Autowired
    private FeignHystrixPaymentService feignHystrixPaymentService;

    @GetMapping("/payment/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        String result = feignHystrixPaymentService.paymentInfoOK(id);
        log.info("**********result:" + result);
        return result;
    }

    /*@HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })*/
    @HystrixCommand //无特定的fallback方法时使用该注解来调用全局fallback方法
    @GetMapping("/payment/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        //int age = 10/0;
        String result = feignHystrixPaymentService.paymentInfoTimeOut(id);
        log.info("**********result:" + result);
        return result;
    }

    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfoTimeOutHandler, id: " + id + "\t o(╥﹏╥)o （客户端）请稍候再试";
    }

    //下面是全局fallback
    public String paymentGlobalFallbackMethod() {
        return "全局异常处理信息，请稍候再试， ค(TㅅT) ";
    }
}
