import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.ReentrantLockDemo
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/23 10:15
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/23      wangtongbang          v1.0.0               修改原因
 */
public class ReentrantLockDemo {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();
    public static void main(String[] args) throws Exception{
        Thread1 thread1 = new Thread1();
        thread1.start();
//        TimeUnit.MILLISECONDS.sleep(300000);

        Thread2 thread2 = new Thread2();
        thread2.start();
    }

    static class Thread1 extends Thread{
        @Override
        public void run(){

            try {
                lock.lock();
                System.out.println("await时间开始");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("await时间结束😄");
            } finally {
//                lock.unlock();
            }
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run(){

            try {
                lock.lock();
                System.out.println("我们执行signal命令来唤醒await命令，让awai结束");
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
