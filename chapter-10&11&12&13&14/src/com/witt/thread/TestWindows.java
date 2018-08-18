package com.witt.thread;

public class TestWindows {

    public static void main(String[] args) {
        TicketDemo td = new TicketDemo();

        Thread t1 = new Thread(td);
        Thread t2 = new Thread(td);
        Thread t3 = new Thread(td);

        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketDemo implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        synchronized (TicketDemo.class ) {
            while (ticket > 0) {
                try {
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " ticket number ：" + ticket--);
            }
        }
    }
}