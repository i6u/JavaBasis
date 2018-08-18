package fun.witt.lambda;

/**
 * @author witt
 * @fileName LambdaDemo
 * @date 2018/8/18 12:59
 * @description
 * @history <author>    <time>    <version>    <desc>
 */

@FunctionalInterface
public interface LambdaDemo {

    int showMe(int n);

    default int add(int a, int b) {
        return a + b;
    }
}
