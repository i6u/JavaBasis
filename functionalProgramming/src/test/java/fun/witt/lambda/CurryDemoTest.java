package fun.witt.lambda;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author witt
 * @fileName CurryDemoTest
 * @date 2018/8/18 17:55
 * @description 级联表达式和柯里化
 * @history <author>    <time>    <version>    <desc>
 */

public class CurryDemoTest {

    @Test
    public void fun() {
        Function<Integer, Function<Integer, Integer>> function = x -> y -> x + y;
        System.out.println(function.apply(2).apply(5).intValue());
    }

    @Test
    public void fun1() {
        Function<Integer, Function<Integer, Function<Integer, Integer>>> function = x -> y -> z -> x + y + z;
        System.out.println(function.apply(1).apply(2).apply(3).intValue());
    }

    @Test
    public void fun2() {
        int[] ints = {2, 3, 4};
        Function<Integer, Function<Integer, Function<Integer, Integer>>> function = x -> y -> z -> x + y + z;

        Function fun = function;

        for (int i : ints) {
            Object obj = fun.apply(i);
            if (obj instanceof Function) {
                fun = (Function) obj;
            } else {
                System.out.println("结果：" + obj);
            }
        }
    }
}
