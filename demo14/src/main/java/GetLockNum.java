import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.GetLockNum
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/23 10:58
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/23      wangtongbang          v1.0.0               修改原因
 */
public class GetLockNum {
    public static ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {

        //ReentrantLock和synchronized一样，锁都是可重入的，
        // 同一线程的同一个ReentrantLock的lock()方法被调用了多少次，
        // getHoldCount()方法就返回多少
        Thread thread = new Thread(()-> {
            try {
                System.out.println("我们来获取下lock被调用的次数");
                lock.lock();
                System.out.println("锁了第一次，看看调用了几次："+lock.getHoldCount());
                lock.lock();
                System.out.println("第二次加锁，我们看调用了几次："+lock.getHoldCount());
            } finally {
                lock.unlock();
            }
        });


        thread.start();


    }
}
