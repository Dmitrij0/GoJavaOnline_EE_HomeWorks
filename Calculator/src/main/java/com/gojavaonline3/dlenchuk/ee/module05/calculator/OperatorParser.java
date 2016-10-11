package com.gojavaonline3.dlenchuk.ee.module05.calculator;

public class OperatorParser<T extends Number> {

    private String expression;
    private Operator<T> operator;
    private Number operand;
    private String operatorString;


    public OperatorParser(String expression, Number operand) {
        this.expression = expression;
        this.operand = operand;
    }

    public Operator<T> getOperator() {
        return operator;
    }

    public void parse() {
        if (expression.contains("+")) {
            operatorString = "+";
        } else if (expression.contains("-")) {
            operatorString = "-";
        } else if (expression.contains("*")) {
            operatorString = "*";
        } else if (expression.contains("/")) {
            operatorString = "/";
        } else {
            throw new UnsupportedOperationException();
        }
        operator = parseOperator();
    }

    private NumberOperator parseOperator() {
        if (operand instanceof Double) {
            return doubleOperator();
        } else {
            if (operand instanceof Float) {
                return floatOperator();
            } else {
                if (operand instanceof Long) {
                    return longOperator();
                } else {
                    return integerOperator();
                }
            }
        }
    }

    private DoubleOperator doubleOperator() {
        if (operatorString.equals("+")) {
            return (Double value1, Double value2) -> value1 + value2;
        } else if (operatorString.equals("-")) {
            return (Double value1, Double value2) -> value1 - value2;
        } else if (operatorString.equals("*")) {
            return (Double value1, Double value2) -> value1 * value2;
        } else if (operatorString.equals("/")) {
            return (Double value1, Double value2) -> value1 / value2;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private FloatOperator floatOperator() {
        if (operatorString.equals("+")) {
            return (Float value1, Float value2) -> value1 + value2;
        } else if (operatorString.equals("-")) {
            return (Float value1, Float value2) -> value1 - value2;
        } else if (operatorString.equals("*")) {
            return (Float value1, Float value2) -> value1 * value2;
        } else if (operatorString.equals("/")) {
            return (Float value1, Float value2) -> value1 / value2;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private LongOperator longOperator() {
        if (operatorString.equals("+")) {
            return (Long value1, Long value2) -> value1 + value2;
        } else if (operatorString.equals("-")) {
            return (Long value1, Long value2) -> value1 - value2;
        } else if (operatorString.equals("*")) {
            return (Long value1, Long value2) -> value1 * value2;
        } else if (operatorString.equals("/")) {
            return (Long value1, Long value2) -> value1 / value2;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private IntegerOperator integerOperator() {
        if (operatorString.equals("+")) {
            return (Integer value1, Integer value2) -> value1 + value2;
        } else if (operatorString.equals("-")) {
            return (Integer value1, Integer value2) -> value1 - value2;
        } else if (operatorString.equals("*")) {
            return (Integer value1, Integer value2) -> value1 * value2;
        } else if (operatorString.equals("/")) {
            return (Integer value1, Integer value2) -> value1 / value2;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public String toString() {
        return operatorString;
    }
}
