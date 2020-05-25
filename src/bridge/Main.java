package bridge;

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
        Computer computer=new Laptop(new Apple());
        computer.info();
    }

}
