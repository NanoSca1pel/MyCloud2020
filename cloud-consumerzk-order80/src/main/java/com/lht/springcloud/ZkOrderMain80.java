package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author lhtao
 * @date 2020/9/3 9:45
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ZkOrderMain80 {

    public static void main(String[] args){
        SpringApplication.run(ZkOrderMain80.class, args);
    }
}
