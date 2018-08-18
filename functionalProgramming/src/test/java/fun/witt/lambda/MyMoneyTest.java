package fun.witt.lambda;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class MyMoneyTest {

    @Test
    public void printMoney() {
        MyMoney myMoney = new MyMoney(992341234);

        // jdk 8 以前
        myMoney.printMoney(new MoneyFormat() {
            @Override
            public String format(int money) {
                return new DecimalFormat("#,###").format(money);
            }
        });
        // jdk 8 以后使用 lambda 表达式
        myMoney.printMoney((MoneyFormat) money -> new DecimalFormat("#,###").format(money));

        // 使用 jdk 内置的函数接口
        myMoney.printMoney((Function<Integer, String>) integer -> new DecimalFormat("#,###").format(integer));
        // 支持链式编程
        Function<Integer, String> moneyFormat = i -> new DecimalFormat("#,###").format(i);
        myMoney.printMoney(moneyFormat.andThen(s -> "$" + s)); // 支持链式编程
    }


    /**
     * @Description: 函数接口使用
     */
    @Test
    public void fun() {
        IntPredicate integerPredicate = integer -> integer > 0;
        System.out.println(integerPredicate.test(2));

        System.out.println(integerPredicate.and(value -> false).or(integerPredicate).test(1));
    }
}