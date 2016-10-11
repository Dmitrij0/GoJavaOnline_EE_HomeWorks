package com.gojavaonline3.dlenchuk.ee.module05.calculator;

public class Calculator implements Calculable {

    private String expression;
    private String displayResult;

    private boolean calculated;

    public Calculator() {
    }

    public Calculator(String expression) {
        this.expression = expression.replaceAll("\\s+", "");
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getDisplayResult() {
        return displayResult;
    }

    public boolean isCalculated() {
        return calculated;
    }

    @Override
    public String calculate(String expression) {
        this.expression = expression;
        if (calculated) {
            throw new IllegalStateException("An expression is already calculated");
        }
        try {
            final OperandParser operandParser = new OperandParser(expression);
            operandParser.parse();
            final OperatorParser<Number> operatorParser = new OperatorParser<>(expression, operandParser.mainOperand());
            operatorParser.parse();
            final Operator<Number> operator = operatorParser.getOperator();
            displayResult = operandParser.getOperands().get(0).toString() + " " +
                    operatorParser.toString() + " " +
                    operandParser.getOperands().get(1).toString() + " = " +
                    operator.toDo(operandParser.getOperands().get(0), operandParser.getOperands().get(1));
            return displayResult;
        } finally {
            calculated = true;
        }
    }

    @Override
    public String toString() {
        return displayResult;
    }
}
