package com.witt.branch;

public class BranchTest {

    public static void main(String[] args) {

        //func1();

        //func2();
    }

    private static void func1() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

    private static void func2() {

        long begin, end;

        begin = System.currentTimeMillis();

        l:
        for (int i = 2; i <= 100; i++) {

            /**
             *
             *  Math.sqrt(i)
             *
             *  x = m * n 一个数可以写成两个数的乘积，m 和 n 是 x 的约数
             *  m 或 n 从 1 开始逐渐递增，当一个数逐渐变大另一个则逐渐变小
             *  当 m 与 n 逐渐趋于相等时 x 可以看成 m 或 n 的平方
             *
             *  所以 x 的约数从 1 开始逐渐趋近与 Math.sqrt(x) 绝不可能大过这个数
             *
             * */

            for (int j = 2; j <= Math.sqrt(i); j++) {
                System.out.println(Math.sqrt(i));
                if (i % j == 0) {
                    continue l;
                }
            }
            System.out.print(i + ", ");
        }
        end = System.currentTimeMillis();
        System.out.println("\ntime: " + (end - begin));
    }
}
