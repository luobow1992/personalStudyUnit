package ProducerCusumerTopic;

import java.util.concurrent.TimeUnit;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: ProducerCusumerTopic.Cusumer
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
public class Cusumer {
    private Object lock;

    public Cusumer(Object lock) {
        this.lock = lock;
    }

    public void consumerValue(){
        try {
            synchronized (lock){
                if(CachePool.value.equals("")){
                    lock.wait();
                }
                System.out.println("消费的数据为："+CachePool.value);
                CachePool.value = "";
                TimeUnit.MILLISECONDS.sleep(1000);
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
