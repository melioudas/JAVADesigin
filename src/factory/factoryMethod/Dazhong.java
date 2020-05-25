package factory.factoryMethod;

/**
 * 大众汽车
 */
public class Dazhong implements Car {

    @Override
    public String name() {
        System.out.println("大众汽车！");
        return null;
    }
}
