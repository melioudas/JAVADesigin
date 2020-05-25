package factory.factoryMethod;

/**
 *  大众工厂
 */
public class DazhongFactory implements CarFactory {

    @Override
    public Car getCar() {
        return new Dazhong();
    }
}
