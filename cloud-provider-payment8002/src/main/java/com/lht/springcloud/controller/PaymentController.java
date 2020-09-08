package com.lht.springcloud.controller;

import com.lht.springcloud.entity.CommonResult;
import com.lht.springcloud.entity.Payment;
import com.lht.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @Value("${server.port}")
    private String serverPort;

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
}
