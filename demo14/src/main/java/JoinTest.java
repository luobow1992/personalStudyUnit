import sun.applet.Main;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.JoinTest
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/17 11:32
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/17      wangtongbang          v1.0.0               修改原因
 */
public class JoinTest {
    public static void main(String[] args) {
        Father father = new Father();
        father.start();
    }


    protected static class Father extends Thread{
        @Override
        public void run(){
            System.out.println("Father第一步执行");
            System.out.println("Father第二步执行");
            Child child = new Child();
            try {
                child.start();
                child.join(10000);
                System.out.println("等待个10秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Father第三步执行");
        }
    }

    protected static class Child extends Thread{
        @Override
        public void run(){
            System.out.println("Child第一步执行");
            System.out.println("Child第二步执行");
        }
    }
}
