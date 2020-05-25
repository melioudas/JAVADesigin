package factory.simple;

/**
 * 简单工厂模式
 *
 * 对于新增加的产品，需要扩展已有代码
 */
public class Consumer {
    public static void main(String[] args) {
        //买车不自己造了，从工厂取

        //1.原买车方式
//        Car car = new Dazhong();
//        car.name();

        //2.简单工厂
        //缺点：违反了开闭原则，即当增加车时需要修改工厂类中的方法
        Car car=CarFactory.getCar("五菱");
        car.name();
    }

}
