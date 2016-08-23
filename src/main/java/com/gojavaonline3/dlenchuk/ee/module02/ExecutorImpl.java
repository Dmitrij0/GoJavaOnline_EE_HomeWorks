package com.gojavaonline3.dlenchuk.ee.module02;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl<T extends Number> implements Executor<T>{

    private final List<Task<? extends T>> tasks = new ArrayList<>();

    private final List<? super T> validResults = new ArrayList<>();
    private final List<? super T> invalidResults = new ArrayList<>();

    private boolean executed;

    private Validator<? super T> validator = new NumberValidator();

    public ExecutorImpl() {
    }

    public ExecutorImpl(List<Task<? extends T>> tasks) {
        this.tasks.addAll(tasks);
    }

    @Override
    public void addTask(Task<? extends T> task) {
        addTask(task, validator);
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) {
        if (executed) {
            throw new IllegalStateException("The tasks is already executed");
        }
        task.execute();
        final T result;
        if (validator.isValid(result = task.getResult())) {
            validResults.add(result);
        } else {
            invalidResults.add(result);
        }
    }

    @Override
    public void execute() {
        tasks.forEach(this::addTask);
        executed = true;
    }

    @Override
    public List<? super T> getValidResults() {
        return validResults;
    }

    @Override
    public List<? super T> getInvalidResults() {
        return invalidResults;
    }
}
