package factory.factoryAbstroct;

/**
 * 小米工厂
 */
public class XiaomiFactory implements IProductFactory{

    @Override
    public IphpneProduct iphoneProduct() {
        return new XiaomoPhone();
    }

    @Override
    public RouterProduct routerProduct() {
        return new XiaomiRouter();
    }
}
