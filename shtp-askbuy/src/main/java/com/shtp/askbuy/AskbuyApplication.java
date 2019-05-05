package com.shtp.askbuy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@MapperScan("com.shtp.askbuy.mapper")
@SpringBootApplication
public class AskbuyApplication {
    public static void main(String[] args) {
        SpringApplication.run(AskbuyApplication.class, args);
    }
}
