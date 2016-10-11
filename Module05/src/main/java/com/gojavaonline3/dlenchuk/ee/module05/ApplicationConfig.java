package com.gojavaonline3.dlenchuk.ee.module05;

import com.gojavaonline3.dlenchuk.ee.module05.calculator.Calculable;
import com.gojavaonline3.dlenchuk.ee.module05.calculator.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {

    @Bean
    public Evaluator evaluator() {
        final Evaluator evaluator = new Evaluator();
        evaluator.setCalculatorFactory(calculatorFactory());
        return evaluator;
    }

    @Bean
    @Scope("prototype")
    public Calculable calculator() {
        return new Calculator();
    }

    @Bean
    public CalculatorFactory calculatorFactory() {
        return this::calculator;
    }

}
