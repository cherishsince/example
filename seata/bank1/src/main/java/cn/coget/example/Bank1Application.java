package cn.coget.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "cn.coget.example.client")
@MapperScan(basePackages = "cn.coget.example.mapper")
public class Bank1Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(Bank1Application.class);
    }
}