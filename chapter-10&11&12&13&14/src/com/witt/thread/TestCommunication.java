package com.witt.thread;

public class TestCommunication {
    public static void main(String[] args) {
        MyCommunication mc = new MyCommunication();
        Thread t1 = new Thread(mc);
        Thread t2 = new Thread(mc);

        t1.setName("A");
        t2.setName("B");

        t1.start();
        t2.start();
    }
}

class MyCommunication implements Runnable {
    private int n;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (n <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + n);
                    n++;
                } else {
                    break;
                }

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
