package other.reflect;

import java.lang.reflect.Constructor;

/**
 * 获取构造方法
 */
public class GETConstructor {
    public static void main(String[] args) throws Exception {
        Class perClass = Person.class;

        Constructor constructor = perClass.getConstructor(String.class, int.class);
        Person zhangsan = (Person) constructor.newInstance("张三", 11);
        Person zhangsan2 = (Person) constructor.newInstance("张三", 11);
        System.out.println(zhangsan == zhangsan2);


        System.out.println("打印全部构造方法");
        for (Constructor c : perClass.getConstructors()) {
            System.out.println(c);
        }
    }
}
