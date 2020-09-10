package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lhtao
 * @date 2020/9/10 9:59
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient //开启服务发现功能，用于向consul或者zookeeper作为注册中心时注册服务
public class ConsulPaymentMain8006 {

    public static void main(String[] args){
        SpringApplication.run(ConsulPaymentMain8006.class, args);
    }

}
