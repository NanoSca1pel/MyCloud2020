package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author lhtao
 * @date 2020/9/15 14:50
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableConfigServer
public class ConfigCenterMain3344 {

    public static void main(String[] args){
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
