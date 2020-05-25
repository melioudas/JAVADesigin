package factory.factoryAbstroct;

/**
 * 小米手机实现
 */
public class XiaomoPhone implements IphpneProduct{

    @Override
    public void start() {
        System.out.println("小米开机");
    }

    @Override
    public void stop() {
        System.out.println("小米关机");
    }

    @Override
    public void call() {
        System.out.println("小米打电话");
    }
}
