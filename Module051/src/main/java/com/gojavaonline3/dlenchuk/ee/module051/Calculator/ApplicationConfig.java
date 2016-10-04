package com.gojavaonline3.dlenchuk.ee.module051.Calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {

    @Bean
    @Scope("prototype")
    public Calculator calculator() {
        return new Calculator();
    }

}
