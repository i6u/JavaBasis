package com.witt.thread;

public class TestThread1 {

    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        Thread t1 = new Thread(subThread);
        Thread t2 = new Thread(subThread);
        t1.start();
        t2.start();
    }
}

class SubThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

