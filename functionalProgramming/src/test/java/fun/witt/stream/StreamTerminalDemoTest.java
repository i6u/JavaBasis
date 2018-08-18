package fun.witt.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: 终止流操作
 * <p>
 * 非短路操作：等待所有结果执行完成
 * forEach/forEachOrdered
 * collect/toArray
 * reduce
 * min/max/count
 * <p>
 * 短路操作：不需要等待所有结果计算完的终止流操作
 * findFirst/findAny
 * allMatch/anyMatch/noneMatch
 */
public class StreamTerminalDemoTest {

    private String str = "Reactor is a fourth-generation Reactive library for building non-blocking applications on the JVM based on the Reactive Streams Specification";

    @Test
    public void fun() {
        Arrays.stream(str.split(" "))
                .parallel()
                .forEach(System.out::println);

        // parallel 并行流使用 forEachOrdered 保证输出顺序
        Arrays.stream(str.split(" "))
                .parallel()
                .forEachOrdered(System.out::println);
    }

    @Test
    public void fun1() {
        // 收集到 list
        List<String> list = Stream.of(str.split(" "))
                .collect(Collectors.toList());
        list.stream().forEach(System.out::print);
        System.out.println("\n" + list.size());

        // set
        Set set = Stream.of(str.split(" "))
                .collect(Collectors.toSet());
        System.out.println(set.size());
    }

    /**
     * @Description: reduce
     */
    @Test
    public void fun2() {
        Optional<String> optional = Arrays.stream(str.split(" "))
                .map(String::toUpperCase)  // 全转换为大写
                .reduce((s1, s2) -> s1 + "_" + s2); // 使用 reduce 前后字符串拼接 _
        System.out.println(optional.orElse(""));//orElse（默认值） optional value 为 null 时显示默认值

        String stringResult = Arrays.stream(str.split(" "))
                .reduce("", (s1, s2) -> s1 + "|" + s2);
        System.out.println(stringResult);

        // 所有单词的长度

        Integer integer = Arrays.stream(str.split(" "))
                .map(s -> s.length())
                .reduce(0, (integer1, integer2) -> integer1 + integer2);
        System.out.println(integer);
    }

    @Test
    public void fun3() {
        OptionalInt optionalInt = new Random().ints()
                .findFirst();
        System.out.println(optionalInt.getAsInt());

        OptionalInt optional = new Random().ints()
                .findAny();
        System.out.println(optional.getAsInt());
    }
}