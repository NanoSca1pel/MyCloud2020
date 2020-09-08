package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lhtao
 * @date 2020/9/7 9:29
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})   //括号中的配置可以不加载数据库连接
@EnableEurekaServer //申明该模块为服务注册中心（服务端）
public class EurekaMain7001 {

    public static void main(String[] args){
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
