import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.JoinTest1
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/17 14:21
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/17      wangtongbang          v1.0.0               修改原因
 */
public class JoinTest1 {
    //利用Join又一个很现实的用处就是如果我A进程的直行必须依赖B进程的直行结果，那么我就可以通过join来操作
    private static volatile int HAHA = 1;
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(){
            @Override
            public synchronized void run(){
                try {
                    TimeUnit.MILLISECONDS.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                HAHA = 2;
                System.out.println("我是Thread进程，我把HAHA改成了："+HAHA);
            }
        };

        thread.start();
        thread.join(100);

        System.out.println(thread.getState());
        System.out.println("我是Main进程，我的HAHA值为："+HAHA);
    }

}
