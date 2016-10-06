package com.gojavaonline3.dlenchuk.ee.module051.calculator1;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private String expression;
    private List operands;
    private Operator operator;

    public Parser(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public List getOperands() {
        return operands;
    }

    public Operator getOperator() {
        return operator;
    }

    public void parse(){
        operands = Arrays.asList(expression.split("[-+/*]"));
        if (expression.contains("+")) {
            
        } else if (expression.contains("-")) {

        } else if (expression.contains("*")) {

        } else if (expression.contains("/")) {

        } else {

        }
    }



    @Override
    public String toString() {
        return "Parser{" +
                "expression='" + expression + '\'' +
                ", operands=" + operands +
                ", operator=" + operator +
                '}';
    }
}
