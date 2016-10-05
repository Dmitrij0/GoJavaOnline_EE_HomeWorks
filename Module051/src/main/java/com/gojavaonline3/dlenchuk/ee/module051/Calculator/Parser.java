package com.gojavaonline3.dlenchuk.ee.module051.Calculator;

import java.util.List;

public interface Parser<T> {

    void parse(String expression);

    List<T> getOperands();

    Operator<T> getOperator();

}
