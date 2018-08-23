package ProducerCusumerTopic;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: ProducerCusumerTopic.ReentrantLockStarter
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/23 15:34
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/23      wangtongbang          v1.0.0               修改原因
 */
public class ReentrantLockStarter {

    public static void main(String[] args) {
        LockProducerCusumer lockProducerCusumer = new LockProducerCusumer();
        Thread produer1 = new Thread(() -> {
            while (true) {
                lockProducerCusumer.produer();
            }
        }, "小明");
        produer1.start();

        Thread produer2 = new Thread(() -> {
            while (true) {
                lockProducerCusumer.produer();
            }
        }, "小海");
        produer2.start();
        Thread consumer = new Thread(() -> {
            while (true) {
                lockProducerCusumer.consumer();
            }
        }, "大芳");

        consumer.start();

    }
}
