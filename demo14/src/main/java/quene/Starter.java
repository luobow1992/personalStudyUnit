package quene;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: quene.Starter
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/8/23 16:04
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/8/23      wangtongbang          v1.0.0               修改原因
 */
public class Starter {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.offer("Hello");
        list.add("Hello");
        System.out.println(list.peek());
    }
}
