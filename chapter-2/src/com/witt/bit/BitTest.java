package com.witt.bit;

public class BitTest {

    public static void main(String[] args) {

        int a = 10, b = 5;

        a = a ^ b;
        b = a ^ b; // a ^ b ^ b = a
        a = a ^ b; // a ^ b ^ a = b

        System.out.format("a,%d;b,%d\n", a, b);

        fun1();
        fun2();
        fun3();
    }

    private static void fun1() {
        int a[] = { 22, 38,38, 22,22, 4, 4, 11, 11 };
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            temp ^= a[i];
        }
        System.out.println(temp);
    }

    private static void fun2() {
        System.out.println(2<<1);
        System.out.println(2<<2);
        System.out.println(2<<3);
        System.out.println(2>>>1);
        System.out.println(2>>>2);
    }

    private static void fun3() {
        System.out.println(Integer.toBinaryString(60));
        System.out.println(Integer.toHexString(60));
    }
}
