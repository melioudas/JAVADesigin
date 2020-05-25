package other;

/**
 * 测试
 */
public class T1 {
    private static boolean type = false;
    private static int flag1 = 1;
    private static int flag2 = 2;
    private static int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000000; i++) {
            A a = new A();
            B b = new B();
            a.start();
            b.start();

            a.join();
            b.join();

        }

    }

    static class A extends Thread {

        public void run() {
            flag1 = 3;
            type = true;
            flag2 = 3;
            sum = flag1 + flag2;
        }
    }

    static class B extends Thread {

        public void run() {
            if (type) {
                if (flag1 == 1 || flag2 == 2) {
                    System.out.println("BENG！");
                }
            }
        }
    }
}
