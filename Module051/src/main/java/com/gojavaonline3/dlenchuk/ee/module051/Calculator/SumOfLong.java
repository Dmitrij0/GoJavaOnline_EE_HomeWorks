package com.gojavaonline3.dlenchuk.ee.module051.Calculator;

public class SumOfLong implements Operator<Long> {

    public String calculate(long value1, long value2) {
        return calculate(Long.valueOf(value1), Long.valueOf(value2));
    }

    @Override
    public String calculate(Long value1, Long value2) {
        return String.valueOf(value1) + " + " + String.valueOf(value2) + " = " + (value1 + value2);
    }

}
