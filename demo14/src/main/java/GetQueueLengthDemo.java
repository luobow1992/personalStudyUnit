import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.GetQueueLengthDemo
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/23 11:05
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/23      wangtongbang          v1.0.0               修改原因
 */
public class GetQueueLengthDemo {
    //获取正在等待的锁的数量。是一种估计值【因为因为方法遍历的过程中，线程的数量可能也在变化】

    public static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"获得了锁");
                    try {
                        TimeUnit.MILLISECONDS.sleep(100000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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

        try {
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
        } finally {
            //因为在这期间只有一个线程会获得锁，所以应该会有4个线程正在等待
            System.out.println("估计下正在等待的线程数："+lock.getQueueLength());
        }

    }
}
