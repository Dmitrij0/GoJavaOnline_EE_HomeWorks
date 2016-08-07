package com.gojavaonline3.dlenchuk.ee.module01;

import java.util.Collection;
import java.util.Map;

public abstract class StatisticMeasurer implements Statisticable, Iterable<Map.Entry<String, Long>> {

    private final Collection<Integer> testCollection;
    private final int samplesCount;
    private final int entryCount;

    private boolean measured;

    public StatisticMeasurer(Collection<Integer> testCollection, int samplesCount, int entryCount) {
        this.testCollection = testCollection;
        this.samplesCount = samplesCount;
        this.entryCount = entryCount;
    }

    public boolean isMeasured() {
        return measured;
    }

    public int getSamplesCount() {
        return samplesCount;
    }

    public int getEntryCount() {
        return entryCount;
    }

/*
    public void executeStatistic() {
        ListMeasurer listMeasurer = null;
        Map<String, Long> statisticMap
        if (!measured) {
            for (int i = 0; i < samplesCount; i++) {
                listMeasurer = new ListMeasurer(testCollection, entryCount);
                listMeasurer.measure();

            }
            measured = true;
        }

    }
*/

}
