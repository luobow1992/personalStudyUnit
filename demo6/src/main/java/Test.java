import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.Test
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/2 18:35
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/2      wangtongbang          v1.0.0               修改原因
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Person person = new Person("张三");
        //获取类Person  class的三种方式
        //func1
        Class clazz1 = person.getClass();
        System.out.println("方式1：" + clazz1);
        //func2
        Class clazz2 = Class.forName("Person");
        System.out.println("方式2：" + clazz2);
        //func3
        Class clazz3 = Person.class;
        System.out.println("方式3：" + clazz3);


        //==============获取构造函数==============
        Constructor[] constructors = clazz1.getConstructors();
        System.out.println("打印构造函数的信息。。。");
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i]);
            Person person1 = (Person)constructors[i].newInstance("张三");
            person1.setName("lisi");
            System.out.println("这个人的名字叫："+person1.getName());
        }


        //==============获取方法=================
        Method[] methods = clazz1.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }
        System.out.println("执行printSomething" +
                "这个方法");
        Method method = clazz1.getMethod("printSomething",String.class);
        method.invoke(person,"wangtb");


    }
}
