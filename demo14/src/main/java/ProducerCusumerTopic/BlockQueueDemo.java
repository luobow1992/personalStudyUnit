package ProducerCusumerTopic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: ProducerCusumerTopic.BlockQueueDemo
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/23 16:13
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/23      wangtongbang          v1.0.0               修改原因
 */
public class BlockQueueDemo {

    static class ProducerConsumer {

        public ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        public static int i = 0;

        public void producer() {
            try {
                blockingQueue.put("元素"+i++);
                System.out.println("生产了一个值：元素"+i);

                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void consumer() {
            try {
                String value = blockingQueue.take();
                System.out.println("消费了一个值：" + value);
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread produer = new Thread(() -> {
            while (true) {
                producerConsumer.producer();
            }
        }, "小明");
        produer.start();

        Thread consumer = new Thread(() -> {
            while (true) {
                producerConsumer.consumer();
            }
        }, "大芳");

        consumer.start();
    }
}
