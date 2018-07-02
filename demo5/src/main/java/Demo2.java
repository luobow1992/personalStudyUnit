import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.Demo2
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/6/29 16:55
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/6/29      wangtongbang          v1.0.0               修改原因
 */
public class Demo2 {

    public static CyclicBarrier caRunCb = new CyclicBarrier(5, new Runnable() {

        private long last = System.currentTimeMillis();

        @Override
        public void run() {
            System.out.println("全部的线程都已经执行完毕了");
        }

    }); // 元胞运行栅栏


    public static CyclicBarrier caRunCb2 = new CyclicBarrier(5, new Runnable() {

        private long last = System.currentTimeMillis();

        @Override
        public void run() {
            System.out.println("[2]全部的线程都已经执行完毕了");
        }

    }); // 元胞运行栅栏

    public static class MyThread extends Thread {
        private int index;

        public MyThread(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("我是进程:" + index);
            try {
                caRunCb.await();
                System.out.println("开始执行进程："+index);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }


    public static class MyThread2 extends Thread {
        private int index;

        public MyThread2(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("[2]我是进程:" + index);
            try {
                caRunCb.await();
                System.out.println("hahahhhhh");
                caRunCb2.await();
                System.out.println("[2]开始执行进程："+index);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 5; i++) {
//            new Thread(new MyThread(i)).start();
            new Thread(new MyThread2(i)).start();
        }

    }
}
