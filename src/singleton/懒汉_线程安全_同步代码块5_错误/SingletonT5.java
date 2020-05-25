package singleton.懒汉_线程安全_同步代码块5_错误;

/**
 * 错误得同步写法！
 */
public class SingletonT5 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Singleton singleton3 = Singleton.getInstance();
                System.out.println("多线程拿到得实例：" + singleton3.hashCode());
            }).start();

        }
        Thread.sleep(1000000L);
    }
}

class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            //放在这里是不对得
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}