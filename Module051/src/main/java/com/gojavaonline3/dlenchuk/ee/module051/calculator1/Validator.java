package com.gojavaonline3.dlenchuk.ee.module051.calculator1;

public interface Validator {

    Class getOperandsClass();

    boolean valid(String expression);

}
