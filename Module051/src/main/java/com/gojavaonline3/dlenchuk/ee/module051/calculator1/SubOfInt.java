package com.gojavaonline3.dlenchuk.ee.module051.calculator1;

public class SubOfInt implements Operator<Integer> {

    public String calculate(int value1, int value2) {
        return calculate(Integer.valueOf(value1), Integer.valueOf(value2));
    }

    @Override
    public String calculate(Integer value1, Integer value2) {
        return String.valueOf(value1) + " - " + String.valueOf(value2) + " = " + (value1 - value2);
    }

}
