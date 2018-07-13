import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.Test2
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/2 19:19
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/2      wangtongbang          v1.0.0               修改原因
 */
public class Test2 {
    //利用invoke在类运行时执行的特点跳过范型检查
    public static void main(String[] args) {
        try {
            addRight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addError(){
//        List<String> list = new ArrayList<String>();
//        list.add(11);
    }

    public static void addRight() throws Exception{
        List<String> list = new ArrayList<String>();
        Class clazz = list.getClass();
        Method method = clazz.getMethod("add",Object.class);
        method.invoke(list,11);
        method.invoke(list,"你好");
        System.out.println(list.toString());
    }
}
