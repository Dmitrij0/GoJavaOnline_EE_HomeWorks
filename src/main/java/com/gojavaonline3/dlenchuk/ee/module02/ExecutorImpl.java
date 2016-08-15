package com.gojavaonline3.dlenchuk.ee.module02;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl<T extends Number> implements Executor<T>{

    private final List<Task<? extends T>> tasks = new ArrayList<>();

    private final List<? super T> validResults = new ArrayList<>();
    private final List<? super T> invalidResults = new ArrayList<>();

    private boolean executed;

    public ExecutorImpl() {
    }

    public ExecutorImpl(List<Task<? extends T>> tasks) {
        this.tasks.addAll(tasks);
    }

    @Override
    public void addTask(Task<? extends T> task) {
        addTask(task, new NumberValidator());
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) {
        if (executed) {
            throw new IllegalStateException("The tasks is already executed");
        }
        if (validator.isValid(task.getValue())) {
            tasks.add(task);
        } else {
            invalidResults.add(task.getValue());
        }
    }

    @Override
    public void execute() {
        tasks.forEach(task -> {
            task.execute();
            validResults.add(task.getResult());
        });
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
