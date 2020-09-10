package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lhtao
 * @date 2020/9/2 10:58
 */
@SpringBootApplication
@EnableEurekaClient //申明注册为往注册中心注册的服务
//@MapperScan("com.lht.springcloud.mapper")
@EnableDiscoveryClient //开启服务发现功能
public class PaymentMain8001 {

    public static void main(String[] args){
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
