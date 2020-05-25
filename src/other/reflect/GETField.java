package other.reflect;

import java.lang.reflect.Field;

/**
 * 测试反射中的方法
 */
public class GETField {
    public static void main(String[] args) throws Exception {
        Class pcls = Person.class;
        //1.获取成员变量的值--只获取public 修饰的
        Field[] fs = pcls.getFields();
        for (Field f : fs) {
            System.out.println(f);
        }
        //只能public
        Field a = pcls.getField("a");
        System.out.println(a);

        //2.获取成员变量name的值
        Person person1 = new Person("小明", 1);
        Field field = pcls.getField("name");
        Object value2 = field.get(person1);
        System.out.println(value2);

        field.set(person1, "小花");
        String nameValue = (String) field.get(person1);
        System.out.println(nameValue);

        System.out.println("===========获取所有成员变量===========");
        //3.获取全部成员变量
        Field[] fields = pcls.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        //访问私有成员变量的值
        Field fage = pcls.getDeclaredField("age");
        fage.setAccessible(true);//忽略访问权限的安全检查
        //获取私有
        int iage = (int) fage.get(person1);
        System.out.println(iage);

        
    }
}
