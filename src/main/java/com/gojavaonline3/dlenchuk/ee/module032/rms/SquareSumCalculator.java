package com.gojavaonline3.dlenchuk.ee.module032.rms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SquareSumCalculator implements SquareSum {

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {
        final Phaser phaser = new Phaser(numberOfThreads);
        final ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        final List<Callable<Long>> callableList = new ArrayList<>(numberOfThreads);

        final int itemCount = values.length / numberOfThreads;

        IntStream.range(0, numberOfThreads).forEach(i -> callableList.add(() -> {
            String threadName = Thread.currentThread().getName();
            long sum = 0L;
            System.out.println(threadName + ": Evaluating...");
            for (int j = i * itemCount; j < ((i != numberOfThreads) ? (i + 1) * itemCount : values.length); j++) {
                sum += values[j] * values[j];
            }
            System.out.println(threadName + ": Waiting for all on the phaser");
            phaser.arrive();
            return sum;
        }));

        try {
            return evaluateTotalSum(executor.invokeAll(callableList));
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    private long evaluateTotalSum(List<Future<Long>> futures) {
        long totalSum = 0L;
        try {
            for (Future<Long> future : futures) {
                totalSum += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return totalSum;
    }

}
