package cn.coget.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Bank2Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(Bank2Application.class);
    }
}