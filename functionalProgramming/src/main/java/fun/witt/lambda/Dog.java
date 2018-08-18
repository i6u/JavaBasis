package fun.witt.lambda;

/**
 * @author witt
 * @fileName Dog
 * @date 2018/8/18 16:33
 * @description
 * @history <author>    <time>    <version>    <desc>
 */

public class Dog {

    private String name = "哮天犬";
    private int food = 21;


    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public static void show(Dog dog) {
        System.out.println(dog);
    }

    public static Dog show() {
        return new Dog("andy");
    }

    @Override
    public String toString() {
        return "Dog{name= '" + name + "'}";
    }

    /**
     * @Description: 非静态方法默认有个参数 this
     * @Param: [num]
     * @return: int
     * @Date: 2018/8/18
     */
    public int eat(Dog this, int num) {
        System.out.println("吃了" + num + "斤狗粮");
        this.food -= num;
        return this.food;
    }

    public Integer eat1(Integer integer) {
        System.out.println("吃了" + integer + "斤狗粮");
        this.food -= integer;
        return this.food;
    }
}
