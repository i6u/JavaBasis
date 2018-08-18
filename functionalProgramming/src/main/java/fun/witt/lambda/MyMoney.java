package fun.witt.lambda;

import java.util.function.Function;

/**
 * @author witt
 * @fileName MyMoney
 * @date 2018/8/18 13:27
 * @description
 * @history <author>    <time>    <version>    <desc>
 */

public class MyMoney {
    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }


    public void printMoney(MoneyFormat moneyFormat) {
        System.out.println("存款: " + moneyFormat.format(this.money));
    }

    /**
     * @Description: 函数接口的使用
     * @Param: [moneyFormat]
     * @return: void
     * @Date: 2018/8/18
     */
    public void printMoney(Function<Integer, String> moneyFormat) {
        System.out.println("存款: " + moneyFormat.apply(this.money));
    }

}

interface MoneyFormat{
    String format(int money);
}