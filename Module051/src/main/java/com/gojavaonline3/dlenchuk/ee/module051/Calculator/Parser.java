package com.gojavaonline3.dlenchuk.ee.module051.Calculator;

import java.util.List;

public interface Parser {

    void parse(String expression);

    List getOperands();

    Operator getOperator();

}
