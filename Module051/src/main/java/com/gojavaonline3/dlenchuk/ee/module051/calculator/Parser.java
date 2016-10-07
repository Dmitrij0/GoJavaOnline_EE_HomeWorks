package com.gojavaonline3.dlenchuk.ee.module051.calculator;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private String expression;
    private List<String> operands;
    private Operator<? extends Number> operator;

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
        parseOperands();
        operator = parseOperator();
    }

    private void parseOperands() {
        operands = Arrays.asList(expression.split("[-+/*]"));
    }

    private Operator<? extends Number> parseOperator() {
        Number number1 = number(operands.get(0));
        Number number2 = number(operands.get(1));

        if (number1 instanceof Double || number2 instanceof Double) {
            return value1 + ((double) number2 < 0 ? " - " : " + ") +
                    String.valueOf(Math.abs((double) number2)) + " = " + ((double)number1 + (double)number2);
        } else {
            if (number1 instanceof Float || number2 instanceof Float) {
                return String.valueOf(value1) + ((float)number2 < 0 ? " - " : " + ") +
                        String.valueOf(Math.abs((float) number2)) + " = " + ((float)number1 + (float)number2);
            } else {
                if (number1 instanceof Long || number2 instanceof Long) {
                    return String.valueOf(value1) + ((long)number2 < 0 ? " - " : " + ") +
                            String.valueOf(Math.abs((long) number2)) + " = " + ((long)number1 + (long)number2);
                } else {
                    return String.valueOf(value1) + ((int)number2 < 0 ? " - " : " + ") +
                            String.valueOf(Math.abs((int) number2)) + " = " + ((int)number1 + (int)number2);
                }
            }
        }

        Operator<? extends Number> operator = null;




        if (expression.contains("+")) {
            operator = (value1, value2) -> value1;
        } else if (expression.contains("-")) {

        } else if (expression.contains("*")) {

        } else if (expression.contains("/")) {

        } else {

        }

        return operator;
    }

    private Number number(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException integerException) {
            try {
                return Long.valueOf(value);
            } catch (NumberFormatException longException) {
                try {
                    return Float.valueOf(value);
                } catch (NumberFormatException floatException) {
                    try {
                        return Double.valueOf(value);
                    } catch (NumberFormatException doubleException) {
                        throw new NumberFormatException(doubleException.getMessage());
                    }
                }
            }
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
