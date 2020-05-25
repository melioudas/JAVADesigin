package builder.nodirector;

/**
 * Main
 *
 * <p><a href="Main.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:afteryuan@gmail.com">Spires</a>
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Worker worker=new Worker();
        Product product=worker.A("大汉堡").getProduct();
        System.out.println(product);
    }

}
