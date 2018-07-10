import java.util.concurrent.DelayQueue;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.StartMain
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/5 17:44
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/5      wangtongbang          v1.0.0               修改原因
 */
public class StartMain {
    public static void main(String[] args) {
        DelayQueue<TestDelay> testDelays = new DelayQueue<TestDelay>();
        testDelays.add(new TestDelay(11));
        testDelays.add(new TestDelay(44));
        testDelays.add(new TestDelay(33));
        testDelays.add(new TestDelay(22));
        testDelays.add(new TestDelay(55));
        System.out.println(testDelays);
    }
}
