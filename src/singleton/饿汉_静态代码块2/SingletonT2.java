package singleton.饿汉_静态代码块2;

/**
 * 饿汉静态代码块实现
 */
public class SingletonT2 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
    }
}

class Singleton {
    //声明私有变量实例
    private static Singleton instance;

    //静态代码块赋值
    static {
        instance = new Singleton();
    }

    //私有化构造函数
    private Singleton() {

    }

    //获取实例方法
    public static Singleton getInstance() {
        return instance;
    }

}
