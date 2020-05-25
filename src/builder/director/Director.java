package builder.director;

/**
 * 指挥工人  核心
 */
public class Director {
    public Product build(Builder builder){
        builder.B();
        builder.A();
        builder.C();
        builder.D();
        return builder.getProduct();


    }

}
