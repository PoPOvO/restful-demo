package org.xli.restfuldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan(basePackages = {"org.xli.restfuldemo.dao"})
@EnableTransactionManagement
public class RestfulDemoApplication{

    public static void main(String[] args) {
        SpringApplication.run(RestfulDemoApplication.class, args);
    }
}

