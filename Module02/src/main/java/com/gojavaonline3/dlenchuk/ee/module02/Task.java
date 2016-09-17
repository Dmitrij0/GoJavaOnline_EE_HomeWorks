package com.gojavaonline3.dlenchuk.ee.module02;

public interface Task<T> {

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает значение
    T getValue();

    // Возвращает результат выполнения
    T getResult();

}