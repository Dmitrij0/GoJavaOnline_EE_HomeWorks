package com.gojavaonline3.dlenchuk.ee.module01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class PerformanceRunner {

    public static void main(String[] args) {
        Measurer entries = new ListMeasurer(new ArrayList<>(), 10_000);
        entries.measure();
        entries.iterator().forEachRemaining(System.out::println);
        System.out.println();

        entries = new ListMeasurer(new LinkedList<>(), 10_000);
        entries.measure();
        entries.iterator().forEachRemaining(System.out::println);
        System.out.println();

        entries = new SetMeasurer(new HashSet<>(), 10_000);
        entries.measure();
        entries.iterator().forEachRemaining(System.out::println);
        System.out.println();

        entries = new SetMeasurer(new TreeSet<>(), 10_000);
        entries.measure();
        entries.iterator().forEachRemaining(System.out::println);
        System.out.println();
    }

}
