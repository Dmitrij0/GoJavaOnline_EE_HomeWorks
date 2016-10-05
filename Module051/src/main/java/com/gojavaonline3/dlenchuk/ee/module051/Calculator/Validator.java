package com.gojavaonline3.dlenchuk.ee.module051.Calculator;

public interface Validator {

    Class getOperandsClass();

    boolean valid(String expression);

}
