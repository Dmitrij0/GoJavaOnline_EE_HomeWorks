package com.gojavaonline3.dlenchuk.ee.module051.Calculator;

public class SubOfDouble implements Operator<Double> {

    public String calculate(double value1, double value2) {
        return calculate(Double.valueOf(value1), Double.valueOf(value2));
    }

    @Override
    public String calculate(Double value1, Double value2) {
        return String.valueOf(value1) + " - " + String.valueOf(value2) + " = " + (value1 - value2);
    }

}
