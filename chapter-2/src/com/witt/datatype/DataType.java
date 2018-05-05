package com.witt.datatype;

public class DataType {

    public static void main(String[] args) {

        // 1
        byte b1 = 'a', b2 = 127, b3 = '$';
        // 2
        short s1 = 32767, s2 = 'a', s3 = '$';
        // 4
        int i1 = -2147483647, i2 = 'a';
        // 8
        long l1 = 9223372036854775807L;

        // 4
        float f1 = 3.4028235E38f;
        // 8
        double d1 = 1.7976931348623157E308d, d2 = 1.7976931348623157E308D;
        // 2
        char c1 = 'a', c2 = '我';

        // JVM 规范中，boolean 变量作为 int 处理，也就是4字节；boolean 数组当做 byte 数组处理
        boolean flag = true;

        System.out.println(b1);
        System.out.println(d1);
        System.out.println(c1);
        System.out.println(Double.MAX_VALUE);

        System.out.println((1.1-0.1)/0.1);

        System.out.println('\u000b');

    }
}

