package singleton.test;

/**
 * 练习
 */
public class MyselfTest {
    public static void main(String[] args) {
        Singleton singleton = Singleton7.getInstance();
        Singleton singleton1 = Singleton7.getInstance();

        System.out.println(singleton.hashCode() + ":" + singleton1.hashCode());

        Singleton s1 = Singleton8.INSTANCE;
        Singleton s2 = Singleton8.INSTANCE;
        System.out.println(s1 == s2);

    }
}

interface Singleton {
    public static Singleton getInstance() {
        return null;
    }
}

//1饿汉式 静态常量
class Singleton1 implements Singleton {
    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}

//2饿汉式 静态代码块
class Singleton2 implements Singleton {
    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}

//3懒汉式线程不安全
class Singleton3 implements Singleton {
    private static Singleton3 instance;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}

//4懒汉式同步方法
class Singleton4 implements Singleton {
    private static Singleton4 instance;

    private Singleton4() {
    }

    public static synchronized Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}

//5.6双重检查
class Singleton5 implements Singleton {
    private volatile static Singleton5 instance;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}

//7.静态内部类
class Singleton7 implements Singleton {

    private Singleton7() {
    }

    private static class S {
        private static Singleton7 singleton7 = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return S.singleton7;
    }
}

//枚举
enum Singleton8 implements Singleton {
    INSTANCE
}