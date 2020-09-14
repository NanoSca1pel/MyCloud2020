package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author lhtao
 * @date 2020/9/14 16:03
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableHystrixDashboard //开启Hystrix图形化界面
public class HystrixDashboardMain9001 {
    public static void main(String[] args){
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }
}
