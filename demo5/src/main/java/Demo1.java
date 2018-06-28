/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.Demo1
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/6/28 18:57
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/6/28      wangtongbang          v1.0.0               修改原因
 */
public class Demo1 {
    public static void main(String[] args) {
        //***********
        ISavePerson aa = (String name)-> System.out.println("我是新的写法："+name);
        aa.savePersonInfo("wangtb");

        //这里的new ISavePerson操作的是一个匿名类，我们不需要再去写一个接口实现去专门实现savePersonInfo这个方法了
        ISavePerson bb = new ISavePerson() {
            @Override
            public void savePersonInfo(String name) {
                System.out.println("我是传统的写法，name为："+name);
            }
        };
        bb.savePersonInfo("wangtb");
    }
}
