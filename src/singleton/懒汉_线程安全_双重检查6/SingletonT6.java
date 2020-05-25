package singleton.懒汉_线程安全_双重检查6;

/**
 * 双重检查
 */
public class SingletonT6 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                Singleton singleton3 = Singleton.getInstance();
                System.out.println("多线程拿到得实例：" + singleton3.hashCode());
            }).start();

        }
        Thread.sleep(1000000L);
    }
}

class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            //放在这里是不对得
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
