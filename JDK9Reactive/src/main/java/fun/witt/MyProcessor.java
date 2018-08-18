package fun.witt;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 * @author witt
 * @fileName MyProcessor
 * @date 2018/8/19 04:35
 * @description
 * @history <author>    <time>    <version>    <desc>
 */

public class MyProcessor extends SubmissionPublisher<String> implements Processor<Integer,String> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("处理数据: " + item);

        if (item % 2 == 0) {
            this.submit("转换数据" + Math.abs(item));
        }

        this.subscription.request(1);

        //this.subscription.cancel();
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        this.subscription.cancel();
    }

    @Override
    public void onComplete() {
        System.out.println("数据已处理完.");
        this.close();
    }
}
