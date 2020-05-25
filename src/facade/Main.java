package facade;

/**
 * 外观模式 -- 门面模式
 * <p>
 * 降低客户端访问复杂度
 * 客户端不与系统耦合，外观类与系统耦合
 * <p>
 * <p>
 * 举例：java Controller和Service与Dao
 */
public class Main {
    public static void main(String[] args) {
        //客户端使用得时候 直接使用门面类的方法，不关心service得实现
        Controller c = new Controller();
        c.sm1();
        c.sm2();
        c.sm3();
    }
}


//门面类
class Controller {
    Service1 service1;
    Service2 service2;
    Service3 service3;

    public Controller() {
        service1 = new Service1();
        service2 = new Service2();
        service3 = new Service3();
    }

    public void sm1() {
        service1.method();
    }

    public void sm2() {
        service2.method();
    }

    public void sm3() {
        service3.method();
    }
}

class Service1 {
    void method() {
        System.out.println("service1 相当复杂得方法！");
    }
}

class Service2 {
    void method() {
        System.out.println("service2 相当复杂得方法！");
    }
}

class Service3 {
    void method() {
        System.out.println("service2 相当复杂得方法！");
    }
}