package com.gojavaonline3.dlenchuk.ee.module031;

import java.util.Random;

public class SimpleSemaphoreRunner {

    private static final Semaphore semaphore = new SimpleSemaphore(new Random().nextInt(40));

    public static void main(String[] args) {
        System.out.println(semaphore);
        for (int i = 0; i < 100; i++) {
            new Thread(new WorkManager(semaphore)).start();
        }

    }
}
