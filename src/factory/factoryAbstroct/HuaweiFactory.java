package factory.factoryAbstroct;

/**
 * 华为工厂
 */
public class HuaweiFactory implements IProductFactory {

    @Override
    public IphpneProduct iphoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public RouterProduct routerProduct() {
        return new HuaweiRouter();
    }
}
