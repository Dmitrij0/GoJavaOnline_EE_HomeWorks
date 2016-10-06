package com.gojavaonline3.dlenchuk.ee.module051.calculator1;

public class SubOfFloat implements Operator<Float> {

    public String calculate(float value1, float value2) {
        return calculate(Float.valueOf(value1), Float.valueOf(value2));
    }

    @Override
    public String calculate(Float value1, Float value2) {
        return String.valueOf(value1) + " - " + String.valueOf(value2) + " = " + (value1 - value2);
    }

}
