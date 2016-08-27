package com.gojavaonline3.dlenchuk.ee.module031;

public class SimpleSemaphore implements Semaphore {

    private static final int DEFAULT_PERMITS_COUNT = 10;

    private final int initPermits;

    private volatile int permits;
    private final Object lock = new Object();

    public SimpleSemaphore() {
        initPermits = DEFAULT_PERMITS_COUNT;
        permits = DEFAULT_PERMITS_COUNT;
    }

    public SimpleSemaphore(int permits) {
        this.initPermits = permits;
        this.permits = permits;
    }

    @Override
    public void acquire() throws InterruptedException {
        acquire(1);
    }

    @Override
    public void acquire(int permits) throws InterruptedException {
        synchronized (lock) {
            if (initPermits < permits) {
                throw new InterruptedException(
                        Thread.currentThread().getName() + ": The pool is too small. Semaphore.permits = " +
                                initPermits + "; acquired permits = " + permits);
            }
            while (this.permits < permits) {
                lock.wait();
            }
            System.out.println(Thread.currentThread().getName() + ": is acquired " + permits);
            this.permits -= permits;
        }
    }

    @Override
    public void release() {
        release(1);
    }

    @Override
    public void release(int permits) {
        synchronized (lock) {
            if ((this.permits += permits) > initPermits) {
                System.out.println(Thread.currentThread().getName() + ": Initial permits exceeded");
                this.permits = initPermits;
            }
            System.out.println(Thread.currentThread().getName() + ": is released " + permits);
            if (permits == 1) {
                lock.notify();
            } else {
                lock.notifyAll();
            }
        }
    }

    @Override
    public int getAvailablePermits() {
        return permits;
    }

    @Override
    public String toString() {
        return "Semaphore: " + permits + '/' + initPermits;
    }
}