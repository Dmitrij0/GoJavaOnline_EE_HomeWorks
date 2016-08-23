package com.gojavaonline3.dlenchuk.ee.module02;

public class IntegerTask implements Task<Integer> {

    private final Integer value;

    private boolean executed;
    private Integer result;

    public IntegerTask(Integer value) {
        this.value = value;
    }

    @Override
    public void execute() {
        result = (int)(value*Math.random()*(Math.random() < 0.5 ? -1 : 1));
        executed = true;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Integer getResult() {
        if (!executed) {
            throw new IllegalStateException("The task is not executed yet");
        }
        return result;
    }
}
