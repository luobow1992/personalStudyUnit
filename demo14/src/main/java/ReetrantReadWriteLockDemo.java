import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.ReetrantReadWriteLockDemo
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/23 13:47
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/23      wangtongbang          v1.0.0               修改原因
 */
public class ReetrantReadWriteLockDemo {

    static class ReadWriteDemo extends ReentrantReadWriteLock{
        public void read(){
            try {
                readLock().lock();
                System.out.println("【read】线程"+Thread.currentThread().getName()+"获取到了锁，当前的时间为："+System.currentTimeMillis());
                TimeUnit.MILLISECONDS.sleep(3000);
                System.out.println("【read】线程"+Thread.currentThread().getName()+"睡眠结束");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readLock().unlock();
            }
        }

        public void write(){
            try {
                writeLock().lock();
                System.out.println("【write】线程"+Thread.currentThread().getName()+"获取到了锁，当前的时间为："+System.currentTimeMillis());
                TimeUnit.MILLISECONDS.sleep(3000);
                System.out.println("【write】线程"+Thread.currentThread().getName()+"睡眠结束");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writeLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReadWriteDemo readWriteDemo = new ReadWriteDemo();

        Runnable writeRunnable = ()->readWriteDemo.write();
        Runnable readRunnable = ()-> readWriteDemo.read();

        Thread[] threads = new Thread[3];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(readRunnable);
            threads[i].start();
        }
        
    }
}
