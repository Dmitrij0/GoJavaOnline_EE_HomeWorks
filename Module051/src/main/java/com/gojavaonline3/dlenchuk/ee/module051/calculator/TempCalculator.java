package com.gojavaonline3.dlenchuk.ee.module051.calculator;

public class TempCalculator {
/*

    private String expression;

    public TempCalculator() {
    }

    public TempCalculator(String expression) {
        this.expression = expression.replaceAll("\\s+", "");
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String calculate() {
        String[] operands = expression.split("[-+]");
        char operator = expression.charAt(operands[0].length());
        switch (operator) {
            case '+':
                return sum(operands[0], operands[1]);
            case '-':
                return sum(operands[0], '-' + operands[1]);
            default:
                throw new UnsupportedOperationException('\'' + operator + '\'' + " is unsupported operator");
        }
    }

    private String sum(String value1, String value2) {
        Number number1 = number(value1);
        Number number2 = number(value2);
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

*/
}
