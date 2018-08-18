package fun.witt.lambda;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.function.*;

/**
 * @author witt
 * @fileName FunctionDemoTest
 * @date 2018/8/18 16:07
 * @description
 * @history <author>    <time>    <version>    <desc>
 */

public class FunctionDemoTest {

    @Test
    public void fun() {
        // 断言
        Predicate<Integer> integerPredicate = integer -> integer > 5;
        System.out.println(integerPredicate.test(2));

        // 消费者，只有输入没有输出，消费一个数据
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("只有输入，没有输出");

        // 生产者，只有输出没有输入，生产一个数据
        Supplier<String> supplier = () -> "abc";
        System.out.println(supplier.get());

        // 输入 T 输出 R 的函数
        Function<Integer, String> function = integer -> new DecimalFormat("#,###").format(integer);
        System.out.println(function.apply(99999999));

        // 一元函数
        UnaryOperator<Integer> unaryOperator = i -> ++i;
        System.out.println(unaryOperator.apply(123).intValue());
        // 指定类型的一元函数
        LongUnaryOperator longUnaryOperator = operand -> operand << 10;
        System.out.println(longUnaryOperator.applyAsLong(2));

        // 两个输入的函数，返回可以是任意对象
        BiFunction<Integer, Integer, Function<Integer, String>> functionBiFunction = (integer, integer2) -> x -> integer + integer2 + x + "";
        System.out.println(functionBiFunction.apply(1, 2).apply(3));


        LongBinaryOperator longBinaryOperator = (left, right) -> left + right;
        System.out.println(longBinaryOperator.applyAsLong(2, 3));
    }
}
