package com.gojavaonline3.dlenchuk.ee.module051.calculator;

public class Calculator implements Сalculable {

    private final String expression;

    public Calculator(String expression) {
        this.expression = expression.replaceAll("\\s+", "");
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public String calculate() {
        final OperandParser operandParser = new OperandParser(expression);
        operandParser.parse();
        final OperatorParser<Number> operatorParser = new OperatorParser<>(expression, operandParser.mainOperand());
        operatorParser.parse();
        final Operator<Number> operator = operatorParser.getOperator();
        return operandParser.getOperands().get(0).toString() + " " +
                operatorParser.toString() + " " +
                operandParser.getOperands().get(1).toString() + " = " +
                operator.toDo(operandParser.getOperands().get(0), operandParser.getOperands().get(1));
    }
}
