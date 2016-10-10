package com.gojavaonline3.dlenchuk.ee.module051.calculator;


@FunctionalInterface
public interface Operator<T> {

    T toDo(T value1, T value2);

}
