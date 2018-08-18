package com.witt.thread;

public class TestSingleton {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }
}


class Singleton {
    private static Singleton INSTANCE = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (INSTANCE != null) {
            synchronized (Singleton.class) {
                if (INSTANCE != null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
