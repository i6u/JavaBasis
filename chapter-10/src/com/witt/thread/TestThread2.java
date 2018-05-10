package com.witt.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestThread2 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);

        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int n = 0;
        for (int i = 0; i <= 100; i++) {
            Thread.currentThread().sleep(10);
            n += i;
        }
        return n;
    }
}
