package com.lht.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lhtao
 * @date 2020/9/17 14:34
 */
@RestController
@RequestMapping("/nacos/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacos registry, serverPort: " + serverPort + "\t id: " + id;
    }
}
