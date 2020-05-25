package factory.factoryAbstroct;

/**
 * 小米手机实现
 */
public class HuaweiPhone implements IphpneProduct {

    @Override
    public void start() {
        System.out.println("华为开机");
    }

    @Override
    public void stop() {
        System.out.println("华为关机");
    }

    @Override
    public void call() {
        System.out.println("华为打电话");
    }
}
