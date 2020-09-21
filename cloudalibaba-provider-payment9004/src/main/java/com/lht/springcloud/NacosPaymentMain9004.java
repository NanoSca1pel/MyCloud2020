package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lhtao
 * @date 2020/9/21 14:33
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class NacosPaymentMain9004 {

    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentMain9004.class,args);
    }
}
