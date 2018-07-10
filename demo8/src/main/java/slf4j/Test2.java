package slf4j;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: slf4j.Test2
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/10 15:47
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/10      wangtongbang          v1.0.0               修改原因
 */
@Slf4j
public class Test2 {
    public static void main(String[] args) {
        log.error("Hello");
        log.debug("Hello");
        log.info("Hello");
    }
}
