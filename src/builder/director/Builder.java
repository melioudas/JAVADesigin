package builder.director;

/**
 * 抽象的建造者
 */
public abstract class Builder {
    abstract void A();

    abstract void B();

    abstract void C();

    abstract void D();

    //完工
    abstract Product   getProduct();
}
