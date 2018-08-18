package fun.witt.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 中间流操作
 *
 * 无状态流操作：当前操作与其他元素没有关系
 * map/mapToXxx
 * flatMap/flatMapXxx
 * filter
 * peek
 * unordered
 *
 * 有状态流操作：当前操作依赖其他元素（比如排序，去重）
 * sorted、distinct、limit、skip
 * */
public class StreamOperationDemoTest {

    private String str = "Reactor is a fourth-generation Reactive library for building non-blocking applications on the JVM based on the Reactive Streams Specification";

    /**
     * @Description: 打印每个单词的长度
     * @Param: []
     * @return: void
     * @Date: 2018/8/18
     */
    @Test
    public void fun() {
        Arrays.stream(str.split(" "))
                .mapToInt(value -> value.length())
                .forEach(System.out::println);
    }

    @Test
    public void fun1() {
        Stream.of(str.split(" "))
                .flatMap(s -> s.chars().boxed())
                .peek(System.out::print)
                .forEach(integer -> System.out.println(" " + (char)integer.intValue()));
    }

    @Test
    public void fun2() {
        int[] ints = {2, 31, 3, 5, 66};
        IntStream.of(ints)
                .sorted()
                .forEach(System.out::println);
    }
}