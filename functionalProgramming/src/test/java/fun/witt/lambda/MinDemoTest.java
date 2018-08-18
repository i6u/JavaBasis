package fun.witt.lambda;


import org.junit.Test;

import java.util.stream.IntStream;

public class MinDemoTest {

    @Test
    public void fun() {

        int[] ints = {12, 12, 312, 412, 15, 235};

        int min = IntStream.of(ints)
                .parallel() //并行计算
                .min()
                .getAsInt();

        System.out.println(min);
    }
}