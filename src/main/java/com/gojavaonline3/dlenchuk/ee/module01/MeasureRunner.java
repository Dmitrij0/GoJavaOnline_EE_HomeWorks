package com.gojavaonline3.dlenchuk.ee.module01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class MeasureRunner {

    private static PrintStream printStream;

    public MeasureRunner() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException {
        printStream = new PrintStream("measurements.txt" );
        report(10_000);
        report(100_000);
        report(1_000_000);
    }

    private static void report(int entryCount) throws IOException {
        MeasureManager measureManager =
                new MeasureManager(Arrays.asList(new ArrayList<>(), new LinkedList<>(),
                        new HashSet<>(), new LinkedHashSet<>(), new TreeSet<>()), 100, entryCount);
        measureManager.executeMeasurements();
        System.out.println();
        measureManager.report(System.out);
        printStream.println();
        measureManager.report(printStream);
    }

}
