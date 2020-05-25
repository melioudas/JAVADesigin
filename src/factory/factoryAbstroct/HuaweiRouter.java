package factory.factoryAbstroct;

/**
 * 小米路由器
 */
public class HuaweiRouter implements RouterProduct{

    @Override
    public void start() {
        System.out.println("华为路由器开机");
    }

    @Override
    public void stop() {
        System.out.println("华为路由器关机");

    }

    @Override
    public void wifi() {
        System.out.println("华为路由器提供wifi");

    }
}
