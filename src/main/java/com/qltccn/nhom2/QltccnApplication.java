package com.qltccn.nhom2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.qltccn.nhom2.mapper")
public class QltccnApplication {

    public static void main(String[] args) {
        SpringApplication.run(QltccnApplication.class, args);
    }

}
