package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lhtao
 * @date 2020/9/15 15:20
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class ConfigClientMain3355 {
    public static void main(String[] args){
        SpringApplication.run(ConfigClientMain3355.class, args);
    }
}
