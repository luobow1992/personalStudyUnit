package ProducerCusumerTopic;

import java.util.concurrent.TimeUnit;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: ProducerCusumerTopic.Producer
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/23 14:49
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/23      wangtongbang          v1.0.0               修改原因
 */
public class Producer {
    private Object lock;

    public Producer(Object lock) {
        this.lock = lock;
    }

    public void producerValue() {
        try {
            synchronized (lock) {
                if (!CachePool.value.equals("")) {
                    lock.wait();
                }
                CachePool.value = "【生产数据】" + System.currentTimeMillis();
                System.out.println("生产的数据为：" + CachePool.value);
                TimeUnit.MILLISECONDS.sleep(1000);
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
