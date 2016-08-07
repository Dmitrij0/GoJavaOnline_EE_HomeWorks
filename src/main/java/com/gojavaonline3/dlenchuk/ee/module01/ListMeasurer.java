package com.gojavaonline3.dlenchuk.ee.module01;

import java.util.*;

public class ListMeasurer extends Measurer {

    private final List<Integer> testList;

    public ListMeasurer(Collection<Integer> testCollection, int entryCount) {
        super(testCollection, entryCount);
        this.testList = (List<Integer>) testCollection;
    }

    @Override
    public void measure() {
        if (!isMeasured()) {
            measureData.clear();
            measureData.put("add", executeAdd());
            measureData.put("get", executeGet());
            measureData.put("remove", executeRemove());
            measureData.put("contains", executeContains());
            measureData.put("populate", executePopulate());
            measureData.put("iterator.add", executeListIteratorAdd());
            measureData.put("iterator.remove", executeListIteratorRemove());
            setMeasured(true);
        }
    }

    private long executeAdd() {
        int index = (int) (Math.random() * getEntryCount());
        int value = (int) (Math.random() * Integer.MAX_VALUE);
        fillTestList();
        long timeSpent = System.nanoTime();
        testList.add(index, value);
        return System.nanoTime() - timeSpent;
    }

    private Long executeGet() {
        int index = (int) (Math.random() * getEntryCount());
        fillTestList();
        long timeSpent = System.nanoTime();
        testList.get(index);
        return System.nanoTime() - timeSpent;
    }

    private Long executeRemove() {
        int index = (int) (Math.random() * getEntryCount());
        fillTestList();
        long timeSpent = System.nanoTime();
        testList.remove(index);
        return System.nanoTime() - timeSpent;
    }

    private Long executeContains() {
        int index = (int) (Math.random() * getEntryCount());
        fillTestList();
        Integer value = testList.get(index);
        long timeSpent = System.nanoTime();
        testList.contains(value);
        return System.nanoTime() - timeSpent;
    }

    private Long executePopulate() {
        long timeSpent = System.nanoTime();
        fillTestList();
        return System.nanoTime() - timeSpent;
    }

    private Long executeListIteratorAdd() {
        int index = (int) (Math.random() * getEntryCount());
        ListIterator<Integer> iterator = testList.listIterator();
        int counter = 0;
        while (iterator.hasNext() && counter++ <= index) {
            iterator.next();
        }
        int value = (int) (Math.random() * Integer.MAX_VALUE);
        long timeSpent = System.nanoTime();
        iterator.add(value);
        return System.nanoTime() - timeSpent;
    }

    private Long executeListIteratorRemove() {
        int index = (int) (Math.random() * getEntryCount());
        ListIterator<Integer> iterator = testList.listIterator();
        int counter = 0;
        while (iterator.hasNext() && counter++ <= index) {
            iterator.next();
        }
        long timeSpent = System.nanoTime();
        iterator.remove();
        return System.nanoTime() - timeSpent;
    }

}
