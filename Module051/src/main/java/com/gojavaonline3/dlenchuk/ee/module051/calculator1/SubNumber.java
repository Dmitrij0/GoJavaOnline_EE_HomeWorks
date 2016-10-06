package com.gojavaonline3.dlenchuk.ee.module051.calculator1;

public class SubNumber<T1 extends Number, T2 extends Number> implements NumberOperator<T1, T2> {

    @Override
    public String toDo(T1 value1, T2 value2) {
        return "";//String.valueOf(value1) + " - " + String.valueOf(value2) + " = " + (value1 - value2);
    }
}
