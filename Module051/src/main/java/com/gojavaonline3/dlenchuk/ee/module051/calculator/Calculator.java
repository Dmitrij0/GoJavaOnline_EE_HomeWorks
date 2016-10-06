package com.gojavaonline3.dlenchuk.ee.module051.calculator;

public class Calculator {

    private String expression;

    public Calculator() {
    }

    public Calculator(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String calculate() {
        String[] operands = expression.split("[-+]]");
        char operator = expression.charAt(operands[0].length());
        switch (operator) {
            case '+':
                sum(operands[0]., operands[1]);

        }
        return "";
    }

    private void sum(String operand, String operand1) {
    }

}
