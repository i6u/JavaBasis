package com.witt.thread;


public class TestThread {

    /**
     *
     * yield
     * join
     * sleep
     *
     */

    public static void main(String[] args) {
        PrimeThread1 pt1 = new PrimeThread1();
        pt1.start();
        //
        //PrimeThread2 primeThread2 = new PrimeThread2();
        //Thread t1 = new Thread(primeThread2);
        //

    }

}

class PrimeThread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

class PrimeThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}