package com.gojavaonline3.dlenchuk.ee.module01;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class StatisticMeasurer implements Statisticable, Iterable<Map.Entry<String, Long>> {

    private final Collection<Integer> testCollection;
    private final int sampleCount;
    private final int entryCount;

    private final Map<String, Long> statisticData = new LinkedHashMap<>();

    private boolean measured;

    public StatisticMeasurer(Collection<Integer> testCollection, int samplesCount, int entryCount) {
        this.testCollection = testCollection;
        this.sampleCount = samplesCount;
        this.entryCount = entryCount;
    }

    public boolean isMeasured() {
        return measured;
    }

    public void setMeasured(boolean measured) {
        this.measured = measured;
    }

    public int getSampleCount() {
        return sampleCount;
    }

    public int getEntryCount() {
        return entryCount;
    }

    public void statistic() {
        Measurer measurer;
        statisticData.clear();
        if (!isMeasured()) {
            final int sampleCount = getSampleCount();
            for (int i = 0; i < sampleCount; i++) {
                measurer = Measurer.measurer(testCollection, getEntryCount());
                measurer.measure();
                Iterator<Map.Entry<String, Long>> iterator = measurer.iterator();
                if (statisticData.isEmpty()) {
                    iterator.forEachRemaining(entry -> statisticData.put(entry.getKey(), entry.getValue()));
                } else {
                    iterator.forEachRemaining(entry ->
                            statisticData.put(entry.getKey(), statisticData.get(entry.getKey()) + entry.getValue()));
                }
            }
            if (!statisticData.isEmpty()) {
                Iterator<Map.Entry<String, Long>> iterator = statisticData.entrySet().iterator();
                iterator.forEachRemaining(entry ->
                        statisticData.put(entry.getKey(), entry.getValue() / sampleCount));
            }
            setMeasured(true);
        }
    }

    public Iterator<Map.Entry<String, Long>> iterator() {
        return statisticData.entrySet().iterator();
    }

    @Override
    public String toString() {
        return "The class of Collection is the " + testCollection.getClass().getSimpleName() +
                ", sampleCount=" + sampleCount +
                ", entryCount=" + entryCount +
                ",\n" + statisticData;
    }
}
