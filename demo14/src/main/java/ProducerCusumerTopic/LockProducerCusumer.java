package ProducerCusumerTopic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: ProducerCusumerTopic.LockProducerCusumer
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/23 15:31
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/23      wangtongbang          v1.0.0               修改原因
 */
public class LockProducerCusumer extends ReentrantLock {
    public Condition condition = newCondition();

    public Condition producerCondition = newCondition();
    public Condition consumerCondition = newCondition();

    public void produer() {

        try {
            lock();
            if (!CachePool.value.equals("")) {
                producerCondition.await();
            }
            lock();
            CachePool.value = "iPhoneX";
            System.out.println("生产者【" + Thread.currentThread().getName() + "】生产了一个：" + CachePool.value);
            TimeUnit.MILLISECONDS.sleep(1000);
            consumerCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            unlock();
        }
    }

    public void consumer() {
        try {
            lock();
            if (CachePool.value.equals("")) {
                consumerCondition.await();
            }
            lock();
            System.out.println("消费者【"+Thread.currentThread().getName()+"】消费了一个：" + CachePool.value);
            CachePool.value = "";
            TimeUnit.MILLISECONDS.sleep(1000);
            producerCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            unlock();
        }
    }
}
