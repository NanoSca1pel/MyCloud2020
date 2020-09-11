package com.lht.springcloud.controller;

import com.lht.springcloud.entity.CommonResult;
import com.lht.springcloud.entity.Payment;
import com.lht.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lhtao
 * @date 2020/9/2 16:08
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        boolean flag = paymentService.save(payment);
        log.info("*********插入结果：" + flag);
        if (flag) {
            return new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, flag);
        } else {
            return new CommonResult(444, "插入数据库失败,serverPort:" + serverPort, flag);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        if (payment != null) {
            log.info("*********查询结果：" + payment.toString());
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "数据库中没有对应记录,serverPort:" + serverPort, payment);
        }
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(p-> log.info(p));
        System.out.println("=================================");
        List<ServiceInstance> instances = discoveryClient.getInstances(applicationName);
        instances.forEach(p-> log.info(p.getServiceId() + "\t" + p.getHost() + "\t" + p.getPort() + "\t" + p.getUri()));

        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }


    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout() {
        try { TimeUnit.SECONDS.sleep(3); } catch(InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }
}
