/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.WaitNotifyDemo
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/23 14:21
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/23      wangtongbang          v1.0.0               修改原因
 */
public class WaitNotifyDemo {
    public static void main(String[] args) {
        MyDemo myDemo = new MyDemo();
        Thread[] threads = new Thread[500];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->myDemo.waitFunc(),"萝卜"+i);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        Thread thread2 = new Thread(()->myDemo.notifyFunc());

        thread2.start();

    }


    static class MyDemo {
        public static Object object = new Object();

        public void waitFunc(){
            synchronized (object){
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"开始执行wait方法，等待30秒");
                    object.wait(300000);
                    System.out.println("线程"+Thread.currentThread().getName()+":wait结束。。。。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void notifyFunc(){
            synchronized (object){
                System.out.println("线程"+Thread.currentThread().getName()+"开始执行notify方法");
                object.notify();
                System.out.println("线程"+Thread.currentThread().getName()+":Notify方法执行结束。。。");
            }
        }
    }
}
