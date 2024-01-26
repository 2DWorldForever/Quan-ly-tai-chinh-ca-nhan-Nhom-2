package com.qltccn.nhom2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MoneyUtils moneyUtils() {
        return new MoneyUtils();
    }
}
