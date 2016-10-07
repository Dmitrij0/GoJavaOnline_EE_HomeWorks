package com.gojavaonline3.dlenchuk.ee.module051.calculator;

public interface Validator {

    Class getOperandsClass();

    boolean valid(String expression);

}
