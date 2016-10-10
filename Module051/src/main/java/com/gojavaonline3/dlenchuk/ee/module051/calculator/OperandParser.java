package com.gojavaonline3.dlenchuk.ee.module051.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperandParser {

    private String expression;
    private List<? extends Number> operands = new ArrayList<>();

    public OperandParser(String expression) {
        this.expression = expression;
    }

    public List<? extends Number> getOperands() {
        return operands;
    }

    public void parse() {
        parseOperands();
    }

    private void parseOperands() {
        Arrays.asList(expression.split("[-+/*]")).forEach(value -> operands.add(number(value)));
    }

    public Number mainOperand() {
        Number number1 = operands.get(0);
        Number number2 = operands.get(1);
        if (number1 instanceof Double || number2 instanceof Double) {
            return Double.valueOf("1");
        } else if (number1 instanceof Float || number2 instanceof Float) {
            return Float.valueOf("1");
        } else if (number1 instanceof Long || number2 instanceof Long) {
            return Long.valueOf("1");
        } else if (number1 instanceof Integer || number2 instanceof Integer) {
            return Integer.valueOf("1");
        } else {
            throw new IllegalArgumentException("Illegal expression: " + expression);
        }
    }

    private <T extends Number> T number(String value) {
        try {
            return (T) Integer.valueOf(value);
        } catch (NumberFormatException integerException) {
            try {
                return (T) Long.valueOf(value);
            } catch (NumberFormatException longException) {
                try {
                    return (T) Float.valueOf(value);
                } catch (NumberFormatException floatException) {
                    try {
                        return (T) Double.valueOf(value);
                    } catch (NumberFormatException doubleException) {
                        throw new NumberFormatException(doubleException.getMessage());
                    }
                }
            }
        }
    }

}
