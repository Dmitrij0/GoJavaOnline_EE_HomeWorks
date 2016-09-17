package com.gojavaonline3.dlenchuk.ee.module02;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class ExecutorTest {

    private static final int ITEM_COUNT = 10;

    private final Random random = new Random();

    private Validator<Number> validator = new NumberValidator();
    private Executor<Integer> executor;

    @Before
    public void setUp() throws Exception {
        executor = new ExecutorImpl<>();
    }

    @Test
    public void addTaskWithValidator() throws Exception {
        executor.addTask(new IntegerTask(0), validator);
        executor.execute();
        assertTrue(executor.getValidResults().size() == 1);
    }

    @Test(expected = IllegalStateException.class)
    public void addTaskWithValidatorException() throws Exception {
        executor.addTask(new IntegerTask(0), validator);
        executor.execute();
        executor.addTask(new IntegerTask(0), validator);
    }

    @Test
    public void addTaskWithValidatorBulk() throws Exception {
        for (int i = 0; i < ITEM_COUNT; i++) {
            executor.addTask(new IntegerTask(random.nextInt(100)), validator);
        }
        executor.execute();
        assertTrue((executor.getValidResults().size() + executor.getInvalidResults().size()) == ITEM_COUNT);
    }

    @Test(expected = IllegalStateException.class)
    public void addTaskWithValidatorBulkException() throws Exception {
        for (int i = 0; i < ITEM_COUNT; i++) {
            executor.addTask(new IntegerTask(random.nextInt(100)), validator);
        }
        executor.execute();
        executor.addTask(new IntegerTask(0), validator);
    }

    @Test
    public void addTask() throws Exception {
        executor.addTask(new IntegerTask(0));
        executor.execute();
        assertTrue(executor.getValidResults().size() == 1);
    }

    @Test(expected = IllegalStateException.class)
    public void addTaskException() throws Exception {
        executor.addTask(new IntegerTask(0));
        executor.execute();
        executor.addTask(new IntegerTask(0));
    }

    @Test
    public void addTaskBulk() throws Exception {
        for (int i = 0; i < ITEM_COUNT; i++) {
            executor.addTask(new IntegerTask(random.nextInt(100)));
        }
        executor.execute();
        assertTrue((executor.getValidResults().size() + executor.getInvalidResults().size()) == ITEM_COUNT);
    }

    @Test(expected = IllegalStateException.class)
    public void addTaskBulkException() throws Exception {
        for (int i = 0; i < ITEM_COUNT; i++) {
            executor.addTask(new IntegerTask(random.nextInt(100)));
        }
        executor.execute();
        executor.addTask(new IntegerTask(0));
    }

    @Test
    public void executeWithoutTasks() throws Exception {
        assertTrue((executor.getValidResults().size() + executor.getInvalidResults().size()) == 0);
        executor.execute();
        assertTrue((executor.getValidResults().size() + executor.getInvalidResults().size()) == 0);
    }

    @Test
    public void execute() throws Exception {
        assertTrue((executor.getValidResults().size() + executor.getInvalidResults().size()) == 0);
        for (int i = 0; i < ITEM_COUNT; i++) {
            executor.addTask(new IntegerTask(random.nextInt(100)));
        }
        executor.execute();
        assertTrue((executor.getValidResults().size() + executor.getInvalidResults().size()) == ITEM_COUNT);
    }

    @Test(expected = IllegalStateException.class)
    public void executeException() throws Exception {
        executor.execute();
        executor.execute();
    }

}