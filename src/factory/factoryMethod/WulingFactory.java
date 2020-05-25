package factory.factoryMethod;

/**
 * 五菱工厂
 */
public class WulingFactory implements CarFactory {

    @Override
    public Car getCar() {
        return new Wuling();
    }
}
