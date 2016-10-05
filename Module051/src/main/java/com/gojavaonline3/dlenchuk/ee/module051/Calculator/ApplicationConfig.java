package com.gojavaonline3.dlenchuk.ee.module051.Calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {

    @Bean
    public Calculator calculator() {
        Calculator calculator = new Calculator();
        calculator.setOperatorFactory(operatorFactory());
        calculator.setValidator(validator());
        calculator.setParser(parser());
        return new Calculator();
    }

    @Bean
    public OperatorFactory operatorFactory() {
        return null;
    }

    @Bean
    @Scope("prototype")
    public Validator validator() {
        return null;
    }

    @Bean
    @Scope("prototype")
    public Parser parser() {
        return null;
    }



}
