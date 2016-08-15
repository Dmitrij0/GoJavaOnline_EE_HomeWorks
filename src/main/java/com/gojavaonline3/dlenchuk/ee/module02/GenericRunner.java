package com.gojavaonline3.dlenchuk.ee.module02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenericRunner {

    private static final int INTEGER_TASK_UPPER_BOUND = 100;

    private static final Random random = new Random();

    public static void main(String[] args) {
        final ArrayList<Task<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < INTEGER_TASK_UPPER_BOUND; i++) {
            if (random.nextInt(INTEGER_TASK_UPPER_BOUND) < INTEGER_TASK_UPPER_BOUND/10) {
                tasks.add(new IntegerTask(-1*random.nextInt(INTEGER_TASK_UPPER_BOUND)));
            } else {
                tasks.add(new IntegerTask(random.nextInt(INTEGER_TASK_UPPER_BOUND)));
            }
        }
        test(tasks);
    }

    private static void test(List<Task<Integer>> intTasks) {
        Executor<Number> numberExecutor = new ExecutorImpl<>();

        intTasks.forEach(numberExecutor::addTask);
        numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        numberExecutor.getValidResults().forEach(System.out::println);
        System.out.println("Invalid results:");
        numberExecutor.getInvalidResults().forEach(System.out::println);
    }

}
