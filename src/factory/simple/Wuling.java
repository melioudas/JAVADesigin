package factory.simple;

/**
 * 五菱汽车
 */
public class Wuling implements Car {

    @Override
    public String name() {
        System.out.println("五菱宏光！");
        return null;
    }
}
