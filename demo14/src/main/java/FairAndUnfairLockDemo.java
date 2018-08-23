import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.FairAndUnfairLockDemo
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/23 10:44
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/23      wangtongbang          v1.0.0               修改原因
 */
public class FairAndUnfairLockDemo {


    //公平锁和非公平锁

    //公平锁就是排序去打饭，打饭窗口只有一个。按照先到先得的原则。排在前面的人有限获得打饭的权利

    //非公平锁类似于古代的抢绣球。小姐姐的绣球只有一个。谁抢到算谁的。其实我们的synchronized就是一种非公平锁

    //我们通过ReetrantLock可以实现公平锁和非公平锁


    //ReentrantLock默认是非公平锁。要在new ReentrantLock(true)中设置

    public static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"：😂😂😂获得了锁");
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"：🌳🌳🌳🌳🌳执行了基本逻辑");
                } finally {
                    lock.unlock();
                }
            }
        };


        Thread thread1 = new Thread(runnable,"萝卜1");
        Thread thread2 = new Thread(runnable,"萝卜2");
        Thread thread3 = new Thread(runnable,"萝卜3");
        Thread thread4 = new Thread(runnable,"萝卜4");
        Thread thread5 = new Thread(runnable,"萝卜5");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

}
