package com.lht.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lhtao
 * @date 2020/9/3 9:54
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsulOrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001";
    //地址中微服务的名称无论大小写都不影响使用
    public static final String PAYMENT_URL = "http://consul-cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/paymentconsul")
    public String paymentInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }
}
