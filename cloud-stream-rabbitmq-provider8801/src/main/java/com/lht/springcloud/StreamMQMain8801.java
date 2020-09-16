package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author lhtao
 * @date 2020/9/16 14:11
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StreamMQMain8801 {

    public static void main(String[] args){
        SpringApplication.run(StreamMQMain8801.class, args);
    }
}
