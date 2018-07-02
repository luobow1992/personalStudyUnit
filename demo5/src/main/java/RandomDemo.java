import java.security.SecureRandom;
import java.util.Random;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.RandomDemo
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/2 15:09
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/2      wangtongbang          v1.0.0               修改原因
 */
public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextInt(10);
    }
}
