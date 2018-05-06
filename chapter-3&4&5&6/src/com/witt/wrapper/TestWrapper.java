package com.witt.wrapper;

public class TestWrapper {

    public static void main(String[] args) {

        int n = 123;
        Integer integer = new Integer(n);
        System.out.println(integer.intValue());

        Integer integer1 = n;
        System.out.println(integer1.intValue());

    }
}
