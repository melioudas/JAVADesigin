package factory.factoryAbstroct;

/**
 * 消费
 */
public class Constor {
    public static void main(String[] args) {
        IProductFactory factory = new XiaomiFactory();
        IphpneProduct iphpneProduct = factory.iphoneProduct();
        iphpneProduct.call();
    }

}
