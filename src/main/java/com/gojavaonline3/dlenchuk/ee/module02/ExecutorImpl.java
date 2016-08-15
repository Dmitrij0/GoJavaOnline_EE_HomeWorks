package com.gojavaonline3.dlenchuk.ee.module02;

import java.util.List;

public class ExecutorImpl<T> implements Executor<T>{



    @Override
    public void addTask(Task<? extends T> task) {

    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? extends T> validator) {

    }

    @Override
    public void execute() {

    }

    @Override
    public List<T> getValidResults() {
        return null;
    }

    @Override
    public List<T> getInvalidResults() {
        return null;
    }
}
