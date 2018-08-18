package fun.witt.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreateDemoTest {

    public static int doubleNum(int num) {
        System.out.println("* 2");
        return num * 2;
    }

    @Test
    public void fun() {
        int[] ints = {2, 3, 4, 5, 6};

        // 使用 stream 内部迭代
        int sum = IntStream.of(ints).sum();
        System.out.println("result sum: " + sum);

        // map 是中间操作 （返回 stream 的都是中间操作）
        // sum 是终止操作
        int sum1 = IntStream.of(ints)
                .map(StreamCreateDemoTest::doubleNum)
                .sum();
        System.out.println("result sum1: " + sum1);

        // 惰性求值 （不调用终止操作，中间操作不会执行）
        IntStream.of(ints)
                .map(StreamCreateDemoTest::doubleNum);
    }

    @Test
    public void fun1() {
        List<String> strings = new ArrayList<>();

        // 从集合创建流
        strings.stream();
        strings.parallelStream();

        // 从数组创建
        Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7});

        // 创建数字流
        IntStream.of(2, 3, 4, 5, 6);
        IntStream.rangeClosed(1, 5);
        //System.out.println(IntStream.rangeClosed(1,100).sum());

        // 使用 random 创建一个无限流
        Random random = new Random();
        random.ints().limit(10);

        // 自己产生流
        Random random1 = new Random();
        Stream.generate(() -> random1.nextInt()).limit(11);

    }

    @Test
    public void fun2() {
        for (int i = 0; i < 5; i++) {
            System.out.println(new Random().ints(3).map(operand -> {
                System.out.print(operand + " ");
                return operand;
            }).sum());
        }
    }

    @Test
    public void fun3() {
        // 取5个10以内的随机数,如果是偶数就加1
        Stream.generate(() -> new Random().nextInt(10))
                .parallel()
                .limit(4)
                .map(integer -> {
                    if (integer % 2 == 0) {
                        return ++integer;
                    }
                    return integer;
                })
                .forEach(integer -> System.out.println(integer));
    }
}