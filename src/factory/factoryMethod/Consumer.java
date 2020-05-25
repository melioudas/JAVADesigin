package factory.factoryMethod;


/**
 * 工厂方法模式
 *
 * 优点：支持增加任意产品
 *
 * 缺点：每个车都有一个自己的工厂，当车过多时，工厂也随之增加
 */
public class Consumer {
    public static void main(String[] args) {
        CarFactory carFactor = new WulingFactory();
        carFactor.getCar().name();
    }

}
