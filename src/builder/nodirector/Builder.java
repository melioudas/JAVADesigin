package builder.nodirector;

/**
 * 建造者
 */
public abstract class Builder {
    abstract Builder A(String msg);

    abstract Builder B(String msg);

    abstract Builder C(String msg);

    abstract Builder D(String msg);

    //完工
    abstract builder.nodirector.Product getProduct();

}
