package com.witt.thread;


/**
 * Clerk
 * Product
 * Consume
 */
public class TestProductConsume {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producter p = new Producter(clerk);
        Consumer c1 = new Consumer(clerk);

        Thread pt1 = new Thread(p);
        Thread pt2 = new Thread(p);
        Thread ct1 = new Thread(c1);

        pt1.start();
        pt2 .start();
        ct1.start();
    }
}

class Clerk {

    private int product;

    //
    public synchronized void productionProduct() {
        if (product <= 10) {
            product++;
            notifyAll();
            System.out.println(Thread.currentThread().getName() + "生产了第" + product + "个产品...");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //
    public synchronized void consumeProduct() {
        if (product >= 5) {
            System.out.println(Thread.currentThread().getName() + "消费了第" + product + "个产品...");
            product--;
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producter implements Runnable {

    private Clerk clerk;

    public Producter(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("start production ...");
        while (true) {
            try {
                Thread.currentThread().sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.productionProduct();
        }
    }
}

class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("start consume ...");
        while (true) {
            try {
                Thread.currentThread().sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}

