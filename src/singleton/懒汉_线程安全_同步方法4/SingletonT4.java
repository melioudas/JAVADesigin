package singleton.懒汉_线程安全_同步方法4;

/**
 * 线程安全懒汉式
 */
public class SingletonT4 {
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
    private static Singleton instance;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
