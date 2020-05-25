package other.reflect;

/**
 * 反射实验
 * <p>
 * 三种获取Class对象的方式
 */
public class GETclass {
    public static void main(String[] args) throws ClassNotFoundException {
        //1
        Class cls1 = Class.forName("other.reflect.Person");
        //2
        Class cls2 = Person.class;
        //3
        Person p = new Person();
        Class cls3 = p.getClass();

        System.out.println(cls1 );
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
    }

}
