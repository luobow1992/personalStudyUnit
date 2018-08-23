import java.util.concurrent.TimeUnit;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.DaemonThread
 * @Description: 守护线程和非守护线程
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/17 13:52
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/17      wangtongbang          v1.0.0               修改原因
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (true) {
                System.out.println("我是：" + i++);
                try {
                    TimeUnit.MICROSECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        try {
            TimeUnit.MICROSECONDS.sleep(5000);
            System.out.println(Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("这里面Thread1是守护进程，默认的main进程是非守护进程，如果main进程结束了，那么守护进程也就结束了");
        //main进程直行到这里生命周期也就结束了
    }

}
