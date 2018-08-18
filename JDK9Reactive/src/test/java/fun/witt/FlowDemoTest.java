package fun.witt;

import org.junit.Test;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class FlowDemoTest {

    @Test
    public void fun() throws InterruptedException {

        // 1. 定义发布者，发布数据类型为 integer
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

        // 2. 定义订阅者
        Subscriber<Integer> subscriber = new Subscriber<>() {

            private Subscription subscription;

            // 建立订阅关系是调用
            @Override
            public void onSubscribe(Subscription subscription) {
                // 保存订阅关系（需要用它来给发布者响应)
                this.subscription = subscription;

                // 请求一个数据
                this.subscription.request(2);
            }

            // 有数据到达时调用
            @Override
            public void onNext(Integer item) {
                System.out.println("接收到数据：" + item);

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 处理完再请求一个数据
                this.subscription.request(1);

                // 或者达到目标，告诉发布者不再接受数据
                //this.subscription.cancel();
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
                // 告诉发布者不再接受数据
                this.subscription.cancel();
            }

            // 全部数据处理完/发布者关闭
            @Override
            public void onComplete() {
                System.out.println("已处理完所有数据");
            }
        };

        // 3. 建立关系
        publisher.subscribe(subscriber);

        // 4. 发布者生产数据，并发布
        for (int i = 0; i < 10000; i++) {
            publisher.submit(i);
        }

        // 5. 关闭发布者
        publisher.close();

        TimeUnit.SECONDS.sleep(1);
    }
}