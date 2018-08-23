import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.ExtendsReetrantLock
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/23 11:15
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/23      wangtongbang          v1.0.0               修改原因
 */
public class ExtendsReetrantLock {


    static class MyReetrantLock extends ReentrantLock{
        public void waitLock(){
            try {
                lock();
                System.out.println("当前的线程："+Thread.currentThread().getName()+"是否持有了锁："+isHeldByCurrentThread());
                TimeUnit.MILLISECONDS.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unlock();
            }
        }
    }

    public static void main(String[] args) {
        MyReetrantLock myLock = new MyReetrantLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myLock.waitLock();
            }
        };


        Thread thread1 = new Thread(runnable,"萝卜1");
        thread1.start();
        Thread thread2 = new Thread(runnable,"萝卜2");
        thread2.start();

        System.out.println("当前的线程："+thread1.getName()+"是否在等待锁"+myLock.hasQueuedThread(thread1));
        System.out.println("当前的线程："+thread2.getName()+"是否在等待锁"+myLock.hasQueuedThread(thread2));

    }
}
