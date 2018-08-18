package fun.witt.lambda;

import org.junit.Test;

import java.util.function.*;

public class MethodReferenceDemoTest {

    @Test
    public void fun() {
        Dog dog = new Dog();
        dog.eat(1);

        //1. 静态方法引用
        Consumer<Dog> consumer = Dog::show;
        consumer.accept(dog);
        Supplier<Dog> supplier = Dog::show;
        System.out.println(supplier.get());

        //2. 非静态方法引用，使用实例对象的非静态方法引用
        Function<Integer, Integer> function = dog::eat;
        System.out.println("还剩下" + function.apply(5) + "斤狗粮");

        UnaryOperator<Integer> integerUnaryOperator = dog::eat;
        System.out.println("还剩下" + integerUnaryOperator.apply(3)+ "斤狗粮");

        IntUnaryOperator intUnaryOperator = dog::eat;
        System.out.println("还剩下" + intUnaryOperator.applyAsInt(3)+ "斤狗粮");

        //3. 非静态方法引用，使用类名的非静态方法引用
        BiFunction<Dog, Integer, Integer> biFunction = Dog::eat1;
        System.out.println("还剩下" + biFunction.apply(dog,2)+ "斤狗粮");

        //4. 构造函数的方法引用
        Supplier<Dog> dogSupplier = Dog::new;
        System.out.println(dogSupplier.get().eat(1));
        // 带参数的构造方法引用
        Function<String, Dog> stringDogFunction = Dog::new;
        System.out.println(stringDogFunction.apply("kim").toString());

    }
}