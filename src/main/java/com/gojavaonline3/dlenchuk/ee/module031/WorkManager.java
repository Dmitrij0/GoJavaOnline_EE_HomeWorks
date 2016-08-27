package com.gojavaonline3.dlenchuk.ee.module031;

import java.util.Random;

import static java.lang.Thread.sleep;

public class WorkManager implements Runnable {

    private final static Random random = new Random();
    private final Semaphore semaphore;

    public WorkManager(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            final int permits;
            sleep(random.nextInt(100));
            semaphore.acquire(permits = random.nextInt(10) + 1);
            System.out.println(Thread.currentThread().getName() + ": is working...");
            sleep(random.nextInt(1000));
            semaphore.release(permits);
            System.out.println(semaphore);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
