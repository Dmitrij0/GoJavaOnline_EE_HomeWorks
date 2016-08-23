package com.gojavaonline3.dlenchuk.ee.module02;

public class LongTask implements Task<Long> {

    private final Long value;

    private boolean executed;
    private Long result;

    public LongTask(Long value) {
        this.value = value;
    }

    @Override
    public void execute() {
        result = (long)(value*Math.random()*(Math.random() < 0.5 ? -1 : 1));
        executed = true;
    }

    @Override
    public Long getValue() {
        return value;
    }

    @Override
    public Long getResult() {
        if (!executed) {
            throw new IllegalStateException("The task is not executed yet");
        }
        return result;
    }
}
