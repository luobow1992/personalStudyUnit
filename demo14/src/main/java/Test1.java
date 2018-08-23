import java.util.concurrent.TimeUnit;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.Test1
 * @Description: 多线程之叫号大厅操作【有问题版】
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/16 14:48
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/16      wangtongbang          v1.0.0               修改原因
 */
public class Test1 implements Runnable {

    private int index = 1;

    private final static int MAX = 500;

    @Override
    public synchronized void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread() + "第" + index + "个人叫到了号");
            index++;
        }
    }

    public static void main(String[] args) {
        final Test1 test1 = new Test1();
        Thread thread1 = new Thread(test1, "1号窗口");
        Thread thread2 = new Thread(test1, "2号窗口");
        Thread thread3 = new Thread(test1, "3号窗口");
        Thread thread4 = new Thread(test1, "4号窗口");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}
