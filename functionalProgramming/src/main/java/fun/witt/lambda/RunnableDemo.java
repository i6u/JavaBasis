package fun.witt.lambda;

/**
 * @author witt
 * @fileName RunnableDemo
 * @date 2018/8/18 13:17
 * @description
 * @history <author>    <time>    <version>    <desc>
 */

public class RunnableDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("start ...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end ...");
    }

    public static void main(String[] args) {
        new Thread(new RunnableDemo()).start();

        new Thread(() -> System.out.println("start")).start();

    }
}
