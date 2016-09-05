package com.gojavaonline3.dlenchuk.ee.module032;

import com.gojavaonline3.dlenchuk.ee.module032.rms.SquareSumCalculator;

import java.util.Random;
import java.util.stream.IntStream;

public class RMSRunner {

    private static final int MAX_ARRAY_VALUE = 10;
    private static final int MAX_ARRAY_SIZE = 1_000_000;
    private static final int MAX_ITEM_COUNT_BY_THREAD = 10_000;
    private static final Random random = new Random();

    public static void main(String[] args) {

        int[] array =
                IntStream
                        .generate(() -> random.nextInt(MAX_ARRAY_VALUE))
                        .limit(random.nextInt(MAX_ARRAY_SIZE))
                        .toArray();

        System.out.println(
                new SquareSumCalculator()
                        .getSquareSum(array, array.length / random.nextInt(MAX_ITEM_COUNT_BY_THREAD)));
    }


}
