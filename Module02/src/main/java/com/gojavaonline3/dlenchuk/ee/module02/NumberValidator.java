package com.gojavaonline3.dlenchuk.ee.module02;

public class NumberValidator implements Validator<Number> {

    @Override
    public boolean isValid(Number result) {
        return result.longValue() >= 0;
    }

}
