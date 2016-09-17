package com.gojavaonline3.dlenchuk.ee.module04;

public class TestModule {

    private static Double sin = Math.random();

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        new Thread(() -> {
            while (true) {
                synchronized (TestModule.class) {
                    System.out.printf("Child: %2f\n", sin = Math.sin(sin));
                }
            }
        }).start();
        Thread.sleep(1000);
        while (true) {
            synchronized (TestModule.class) {
                System.out.printf("Main: %2f\n", sin);
                System.out.println("============================================");
            }
        }
    }

}
