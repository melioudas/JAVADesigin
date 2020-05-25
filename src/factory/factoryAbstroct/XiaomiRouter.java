package factory.factoryAbstroct;

/**
 * 小米路由器
 */
public class XiaomiRouter implements RouterProduct{

    @Override
    public void start() {
        System.out.println("小米路由器开机");
    }

    @Override
    public void stop() {
        System.out.println("小米路由器关机");

    }

    @Override
    public void wifi() {
        System.out.println("小米路由器提供wifi");

    }
}
