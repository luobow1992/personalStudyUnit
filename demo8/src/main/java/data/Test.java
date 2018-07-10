package data;

import lombok.Data;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: data.Test
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/10 15:41
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/10      wangtongbang          v1.0.0               修改原因
 */
@Data
public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(12);
        person.setName("朵朵");
        person.setSex("女");
        System.out.println(person.toString());;
    }
}
