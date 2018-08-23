package ProducerCusumerTopic;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: ProducerCusumerTopic.Starter
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/23 14:54
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/23      wangtongbang          v1.0.0               修改原因
 */
public class Starter {
    public static void main(String[] args) throws Exception {
        Object object = new Object();
        Cusumer cusumer = new Cusumer(object);
        Producer producer = new Producer(object);
        Thread thread1 = new Thread(() -> {
            while (true) {
                cusumer.consumerValue();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            while (true) {
                producer.producerValue();
            }
        });
        thread2.start();
    }
}
