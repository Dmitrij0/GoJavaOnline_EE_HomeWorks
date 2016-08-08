package com.gojavaonline3.dlenchuk.ee.module01;

import java.util.*;

public abstract class Measurer implements Measurable, Iterable<Map.Entry<String, Long>>{

    private final Collection<Integer> testCollection;

    private final int entryCount;

    private boolean measured;

    final Map<String, Long> measureData = new LinkedHashMap<>();


    public static Measurer measurer(Collection<Integer> testCollection, int entryCount) {
        return testCollection instanceof List ? new ListMeasurer(testCollection, entryCount) :
                testCollection instanceof Set ? new SetMeasurer(testCollection, entryCount) : null;
    }


    public Measurer(Collection<Integer> testCollection, int entryCount) {
        this.testCollection = testCollection;
        this.entryCount = entryCount;
    }

    public boolean isMeasured() {
        return measured;
    }

    void setMeasured(boolean measured) {
        this.measured = measured;
    }

    int getEntryCount() {
        return entryCount;
    }

    void fillTestList() {
        testCollection.clear();
        for (int i = 0; i < entryCount; i++) {
            testCollection.add(i);
        }
    }

    public Iterator<Map.Entry<String, Long>> iterator() {
        return measureData.entrySet().iterator();
    }

    public String toString() {
        return "The class of Collection is the " + testCollection.getClass().getSimpleName() +
                ", entryCount = " + entryCount +
                ",\nmeasureData=" + measureData;
    }

}
