package fun.witt.stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @author witt
 * @fileName StreamPrincipleDemo
 * @date 2018/8/19 02:51
 * @description 流运行原理
 * @history <author>    <time>    <version>    <desc>
 */

public class StreamPrincipleDemo {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.generate(() -> new Random().nextInt(100))
                .limit(100)
                .parallel()
                .peek(integer -> println(" peek 1 " + integer))
                .filter(integer -> {
                    println(" filter 1 " + integer);
                    return integer > 0;
                })
                .sorted((o1, o2) -> {
                    println(" sort");
                    return o1.compareTo(o2);
                })
                .peek(integer -> println(" peek 2 " + integer));
        integerStream.count();

    }

    private static void println(String s) {
        System.out.println(Thread.currentThread().getName() + " " + s);
    }
}
