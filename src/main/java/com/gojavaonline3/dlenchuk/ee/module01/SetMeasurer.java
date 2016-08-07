package com.gojavaonline3.dlenchuk.ee.module01;

import java.util.*;

public class SetMeasurer extends Measurer {

    private final Set<Integer> testSet;

    public SetMeasurer(Set<Integer> testSet, int entryCount) {
        super(testSet, entryCount);
        this.testSet = testSet;
    }

    @Override
    public void measure() {
        if (!isMeasured()) {
            measureData.clear();
            measureData.put("add", executeAdd());
            measureData.put("remove", executeRemove());
            measureData.put("contains", executeContains());
            measureData.put("populate", executePopulate());
            setMeasured(true);
        }
    }

    private long executeAdd() {
        int value = (int) (Math.random() * Integer.MAX_VALUE);
        fillTestList();
        long timeSpent = System.nanoTime();
        testSet.add(value);
        return System.nanoTime() - timeSpent;
    }

    private Long executeRemove() {
        Integer value = (int) (Math.random() * getEntryCount());
        fillTestList();
        long timeSpent = System.nanoTime();
        testSet.remove(value);
        return System.nanoTime() - timeSpent;
    }

    private Long executeContains() {
        Integer value = (int) (Math.random() * getEntryCount());
        fillTestList();
        long timeSpent = System.nanoTime();
        testSet.contains(value);
        return System.nanoTime() - timeSpent;
    }

    private Long executePopulate() {
        long timeSpent = System.nanoTime();
        fillTestList();
        return System.nanoTime() - timeSpent;
    }

}
