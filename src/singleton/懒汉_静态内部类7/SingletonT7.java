package singleton.懒汉_静态内部类7;

/**
 * 静态内部类，线程安全 懒加载 值得拥有！
 * <p>
 * 懒加载：当调用静态内部类时，内部类才会加载
 * 线程安全：JVM加载类时可以保证线程安全
 */
public class SingletonT7 {
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

    private Singleton() {
    }

    private static class Instance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Instance.INSTANCE;
    }
}
