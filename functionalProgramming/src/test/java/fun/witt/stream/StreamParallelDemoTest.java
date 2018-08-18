package fun.witt.stream;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamParallelDemoTest {

    public static void debug1(int n) {
        System.out.println("debug 1 : " + n);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void debug2(int n) {
        System.out.println("debug 2 : " + n);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void debug3(int n) {
        System.out.println(Thread.currentThread().getName() + "debug 3 : " + n);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fun() {
        IntStream.range(1, 20)
                .parallel()  // 并行
                .peek(StreamParallelDemoTest::debug1)
                .count();
    }

    @Test
    public void fun1() {
        IntStream.range(1, 20)
                .parallel()  // 并行
                .peek(StreamParallelDemoTest::debug1)
                //.sequential() // 串行 (并行、串行只能取其一）
                .peek(StreamParallelDemoTest::debug2)
                .count();
    }

    @Test
    public void fun2() {
        // 修改默认线程数（默认为当前机器的核心数）
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        IntStream.range(1, 100)
                .parallel()  // 并行
                .peek(StreamParallelDemoTest::debug3)
                .count();
    }

    @Test
    public void fun3() {
        // 使用自定义线程池，防止任务被默认线程池阻塞
        ForkJoinPool forkJoinPool = new ForkJoinPool(20);
        forkJoinPool.submit(() -> IntStream.range(1, 100).parallel().peek(StreamParallelDemoTest::debug3).count());
        forkJoinPool.shutdown();

        // 主线程不退出
        synchronized (forkJoinPool) {
            try {
                forkJoinPool.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}