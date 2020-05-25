package other.reflect;

import java.lang.reflect.Method;

/**
 * 反射获取方法
 */
public class GETMethod {
    public static void main(String[] args) throws Exception {
        Class pcls = Person.class;
        Method eat = pcls.getMethod("eat");
        Person p = Person.class.newInstance();
        eat.invoke(p);

        Method eatStr = pcls.getMethod("eat", String.class);
        String s = (String) eatStr.invoke(p, "苹果");
        System.out.println(s);
        //打印类名
        System.out.println(pcls.getName());

        //获取全部方法时会获取到父类的方法
        System.out.println("================打印全部public方法======================");
        Method[] ms = pcls.getMethods();
        for (Method m : ms) {
            System.out.println(m);
        }

    }
}
