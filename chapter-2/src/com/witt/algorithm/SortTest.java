package com.witt.algorithm;



public class SortTest {

    public static void main(String[] args) {
        int[] num = {31, 43, 18, 15, 13, 16, 55, 1, 123, 12, 75, 81, 23};
        fun1(num);
        fun2(num);
    }

    // 冒泡
    private static void fun1(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    num[j] = num[j] ^ num[j + 1];
                    num[j + 1] = num[j] ^ num[j + 1];
                    num[j] = num[j] ^ num[j + 1];
                }
            }
        }
        for (int i : num) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 选择排序
    private static void fun2(int[] num) {
        for (int i = 0; i < num.length; i++) {
            int min = i;
            for (int j = i; j < num.length; j++) {
                if (num[min] > num[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = num[min];
                num[min] = num[i];
                num[i] = temp;
            }
        }
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}
