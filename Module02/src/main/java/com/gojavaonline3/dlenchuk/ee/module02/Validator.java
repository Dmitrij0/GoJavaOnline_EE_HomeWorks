package com.gojavaonline3.dlenchuk.ee.module02;

public interface Validator<T> {

    // Валидирует переданое значение
    boolean isValid(T result);

}