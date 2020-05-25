package singleton.饿汉_静态常量1;

/**
 * 饿汉式 静态变量实现
 */
public class SingletonT1 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);
    }

}

class Singleton {
    //1.私有化无参构造器
    private Singleton() {

    }
    //2.初始化创建实例
    private static final Singleton singleton = new Singleton();
    //3.获取方法
    public static Singleton getInstance() {
        return singleton;
    }
}