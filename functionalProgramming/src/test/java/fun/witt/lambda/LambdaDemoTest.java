package fun.witt.lambda;

import org.junit.Test;

public class LambdaDemoTest {

    // lambda 常见的4种写法
    @Test
    public void fun() {
        LambdaDemo result = n -> n;     // lambda 返回了一个指定接口的对象实例
        LambdaDemo result1 = (n) -> ++n;
        LambdaDemo result2 = (int n) -> --n;
        LambdaDemo result3 = (int n) -> {
            int x = 3 * n;
            return x;
        };

        System.out.println(result.showMe(2));
        System.out.println(result1.showMe(2));
        System.out.println(result2.showMe(2));
        System.out.println(result3.showMe(2));
    }

    @Test
    public void fun1() {
        LambdaDemo lambdaDemo = n -> n + 10;
        System.out.println(lambdaDemo.showMe(2));
        System.out.println(lambdaDemo.add(1, 2));
    }
}