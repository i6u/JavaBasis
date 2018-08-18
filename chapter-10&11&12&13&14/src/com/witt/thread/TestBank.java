package com.witt.thread;

public class TestBank {

    public static void main(String[] args) {
        Customer customer = new Customer(new Account());

        Thread t1 = new Thread(customer);
        Thread t2 = new Thread(customer);

        t1.start();
        t2.start();
    }
}

class Customer implements Runnable {
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}

class Account {
    private double balance;

    // depositor
    public synchronized void deposit(double atm) {
        balance += atm;
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + balance);
    }
}