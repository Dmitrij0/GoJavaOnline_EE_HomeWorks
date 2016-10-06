package com.gojavaonline3.dlenchuk.ee.module051.calculator1;

public interface Operation<T1, T2> {

     default String toDo(T1 value1, Operator<T1, T2> operator, T2 value2) {
         return operator.toDo(value1, value2);
     }

}
