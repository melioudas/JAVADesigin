package builder.nodirector;

/**
 * Worker
 *
 * <p><a href="Worker.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:afteryuan@gmail.com">Spires</a>
 * @version 1.0
 */
public class Worker extends Builder {

    private builder.nodirector.Product product;

    Worker() {
        product = new builder.nodirector.Product();
    }

    @Override
    Builder A(String msg) {
        product.setBuildA(msg);
        return this;
    }

    @Override
    Builder B(String msg) {
        product.setBuildB(msg);
        return this;
    }

    @Override
    Builder C(String msg) {
        product.setBuildC(msg);
        return this;
    }

    @Override
    Builder D(String msg) {
        product.setBuildD(msg);
        return this;
    }

    @Override
    Product getProduct() {
        return product;
    }
}
