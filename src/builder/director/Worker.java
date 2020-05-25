package builder.director;

/**
 * 工人
 */
public class Worker extends Builder {
    private Product product;

    public Worker() {
        this.product = new Product();
    }

    @Override
    void A() {
        product.setBuildA("进行A步骤");
        System.out.println("进行A步骤");

    }

    @Override
    void B() {
        product.setBuildB("进行B步骤");
        System.out.println("进行B步骤");
    }

    @Override
    void C() {
        product.setBuildC("进行C步骤");
        System.out.println("进行C步骤");
    }

    @Override
    void D() {
        product.setBuildD("进行D步骤");
        System.out.println("进行D步骤");
    }

    @Override
    Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "product=" + product +
                '}';
    }
}
