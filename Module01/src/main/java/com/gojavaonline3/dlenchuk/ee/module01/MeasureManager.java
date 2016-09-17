package com.gojavaonline3.dlenchuk.ee.module01;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class MeasureManager implements Iterable<Map.Entry<String, StatisticMeasurer>>{

    public static List<String> LIST_OF_METHODS =
            Arrays.asList("add", "get", "remove", "contains", "populate", "iterator.add", "iterator.remove");

    private final List<Collection<Integer>> collectionTypes;
    private final int sampleCount;
    private final int entryCount;


    private boolean measured;

    private Map<String, StatisticMeasurer> measuredData = new LinkedHashMap<>();

    public MeasureManager(List<Collection<Integer>> collectionTypes, int sampleCount, int entryCount) {
        this.collectionTypes = collectionTypes;
        this.sampleCount = sampleCount;
        this.entryCount = entryCount;
    }

    public boolean isMeasured() {
        return measured;
    }

    public void executeMeasurements() {
        if (!measured) {
            collectionTypes.forEach(item -> {
                        final StatisticMeasurer statisticMeasurer = new StatisticMeasurer(item, sampleCount, entryCount);
                        statisticMeasurer.statistic();
                        measuredData.put(item.getClass().getSimpleName(), statisticMeasurer);
                    }
            );
            measured = true;
        }
    }

    public void report(PrintStream out) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        collectionTypes
                .forEach(item -> stringBuilder.append(item.getClass().getSimpleName()).append(", "));
        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
        out.println("Measured Collections are [" + stringBuilder.toString() + ']');
        out.println("sampleCount=" + sampleCount + ", entryCount=" + entryCount);
        out.println("Time in nanoseconds");
        if (measured) {
            out.println("=================================================================================================================================");
            out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|",
                    "", "add", "get", "remove", "contains", "populate", "iterator.add", "iterator.remove");
            out.println();
            out.println("=================================================================================================================================");
            measuredData.forEach((name, collection) -> {
                out.printf("|%-15s", name);
                for (String key : LIST_OF_METHODS) {
                    final Iterator<Map.Entry<String, Long>> iterator = collection.iterator();
                    boolean found = false;
                    for (Map.Entry<String, Long> entry : collection) {
                        entry = iterator.next();
                        if (key.equals(entry.getKey())) {
                            out.printf("|%15d", entry.getValue());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        out.printf("|%-15s", "N/A" );
                    }
                }
                out.println("|");
            });
            out.println("=================================================================================================================================");
        } else {
            out.println();
            out.println("The measurements were not executed.");
        }
    }

    @Override
    public Iterator<Map.Entry<String, StatisticMeasurer>> iterator() {
        return measuredData.entrySet().iterator();
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        collectionTypes
                .forEach(item -> stringBuilder.append(item.getClass().getSimpleName()).append(", "));
        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
        return "Measured Collections are [" + stringBuilder.toString() +
                "], sampleCount=" + sampleCount +
                ", entryCount=" + entryCount +
                ",\n" + measuredData;
    }
}
