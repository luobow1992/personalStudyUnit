/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.Test
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/11 11:21
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/11      wangtongbang          v1.0.0               修改原因
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("张三");
        //如果setname里面想输入int类型就会报错。因为我们在Person类中限定了属性必须为String

        Person1 person1 = new Person1();
        person1.setName("张三");
        person1.setName(11);
        person1.setName(11.1);
        String str1 = new String("11");
        str1.intern();
    }

}
