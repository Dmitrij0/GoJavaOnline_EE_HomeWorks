package com.gojavaonline3.dlenchuk.ee.module051.calculator1;

public abstract class OperatorFactory {

    public static Operator operator(String expression) {
        return new Parser(expression).getOperator();
    }

}