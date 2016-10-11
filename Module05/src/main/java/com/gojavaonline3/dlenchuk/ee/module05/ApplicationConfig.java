package com.gojavaonline3.dlenchuk.ee.module05;

import com.gojavaonline3.dlenchuk.ee.module05.calculator.Calculator;
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
