import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.TestDelay
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/5 16:53
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/5      wangtongbang          v1.0.0               修改原因
 */
public class TestDelay implements Delayed {
    private long number;

    public TestDelay(int number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public int compareTo(Delayed delayed) {
        TestDelay testDelay = (TestDelay) delayed;
        return this.number > testDelay.getNumber() ? 1 : 0;

    }

    @Override
    public long getDelay(TimeUnit unit) {
        return this.number - System.currentTimeMillis();
    }
}
