package com.lht.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.lht.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author lhtao
 * @date 2020/9/2 16:06
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    //============================服务降级=================================

    @Override
    public String paymentInfoOK(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfoOK, id: " + id + "\t ヾ(Ő∀Ő๑)ﾉ太好惹";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @Override
    public String paymentInfoTimeOut(Integer id) {
        //int age = 10/0;
        int timeNumber = 3000;
        try { TimeUnit.MILLISECONDS.sleep(timeNumber); } catch(InterruptedException e) { e.printStackTrace(); }
        return "线程池: " + Thread.currentThread().getName() + " paymentInfoTimeOut, id: " + id + "\t ヽ(ｏ`皿′ｏ)ﾉ  耗时" + timeNumber + "秒钟";
    }

    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfoTimeOutHandler, id: " + id + "\t o(╥﹏╥)o （服务端）请稍候再试";
    }









    //============================服务熔断=================================
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",
        commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期，服务熔断后断路器进入开启状态，持续该时间后进入半开状态，尝试恢复服务，恢复成功进入关闭状态，在此时间段内服务无法访问
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //在等同于时间窗口期的时间范围内，请求次数中失败率达到百分之多少就会发生服务熔断
        })
    @Override
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*********id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t 调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id) {
        return "id 不能为负数，请稍候再试，o(╥﹏╥)o   id:" + id;
    }
}
