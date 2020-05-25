package singleton.枚举7;

/**
 * 枚举类得实现
 */
public class Singleton7 {
    public static void main(String[] args) {
        Singleton.SINGLETON.say(); 
    }

}

enum Singleton {
    SINGLETON;

    public void say() {
        System.out.println("la la la");
    }
}