package com.gojavaonline3.dlenchuk.ee.module051.calculator1;

public class Calculator implements Сalculable {

    private final String expression;

    public Calculator(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public String calculate() {
        return null;
    }
}
