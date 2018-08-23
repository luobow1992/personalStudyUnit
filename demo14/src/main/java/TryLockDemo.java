import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.TryLockDemo
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/23 11:26
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/23      wangtongbang          v1.0.0               修改原因
 */
public class TryLockDemo {
    static class MyReetrantLock extends ReentrantLock {
        public static volatile boolean getLockFlag = true;

        public void tryLockFunc() {
            try {
                if (tryLock(1000, TimeUnit.MILLISECONDS)) {
                    System.out.println("当前线程："+Thread.currentThread().getName()+"可以获得锁");

                    lock();
                }else {
                    getLockFlag = false;
                    System.out.println("当前线程!!!!!!："+Thread.currentThread().getName()+"😢没有获得锁");
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                if(getLockFlag){
                    unlock();
                }
            }
        }
    }


    public static void main(String[] args) throws Exception{
        MyReetrantLock myLock = new MyReetrantLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myLock.tryLockFunc();
            }
        };


        Thread thread1 = new Thread(runnable,"我叫线程1");
        thread1.start();
        Thread thread2 = new Thread(runnable,"我叫线程2");
        thread2.start();
    }


}
