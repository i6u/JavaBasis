package com.witt.design;

public class TestPattern {

    public static void main(String[] args) {
        Singleton3 singleton3 = Singleton3.INSTANCE;
        Singleton3 singleton31 = Singleton3.INSTANCE;
        System.out.println(singleton3 == singleton31);
    }


}

// 饿汉式
class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }
}


// 双重检查（Double Check）下的懒汉
class Singleton2 {
    private static volatile Singleton2 INSTANCE;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton2.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton2();
                }
            }
        }
        return INSTANCE;
    }
}


// 枚举
enum Singleton3 {
    INSTANCE;


    @Override
    public String toString() {
        return super.toString();
    }
}