package factory.factoryAbstroct;

/**
 * 抽象产品工厂
 */
public interface IProductFactory {
    //生产手机
    IphpneProduct iphoneProduct();

    //生产路由器
    RouterProduct routerProduct();

}
