package com.witt.array;

import java.util.Scanner;

public class TestArray {

    public static void main(String[] args) {
        //fun1();

        //fun2();

        //fun3();

        fun4();
    }

    private static void fun4() {
        int[] num = {12, 43, 12, 15, 13, 16, 55};
        for (int i = 0, j = num.length - 1; i < j; i++, j--) {
            num[i] = num[i] ^ num[j];
            num[j] = num[i] ^ num[j];
            num[i] = num[i] ^ num[j];
        }
        for (int i : num) {
            System.out.print(i + " ");
        }
    }

    // 杨辉三角
    private static void fun3() {

        // 初始化
        int[][] triangle = new int[10][];

        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];

            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0 || i == j) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
                }
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fun2() {
        Scanner s = new Scanner(System.in);
        System.out.println("输入数组大小：");
        int count = s.nextInt();

        int[] scores = new int[count];
        int maxScore = 0;
        for (int i = 0; i < scores.length; i++) {
            System.out.println("输入一个数：");
            int score = s.nextInt();
            scores[i] = score;
            if (score > maxScore) {
                maxScore = score;
            }
        }
        System.out.println("最大为：" + maxScore);
    }

    private static void fun1() {
        int[] n = {1, 2, 3, 4, 5}, n1 = new int[3], n2 = new int[]{1, 2, 3, 'a'};

        int[][] c = new int[][]{{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}};

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j]);
            }
            System.out.println();
        }
    }

}
