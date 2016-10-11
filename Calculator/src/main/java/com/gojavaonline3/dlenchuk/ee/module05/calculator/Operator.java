package com.gojavaonline3.dlenchuk.ee.module05.calculator;


@FunctionalInterface
public interface Operator<T> {

    T toDo(T value1, T value2);

}
