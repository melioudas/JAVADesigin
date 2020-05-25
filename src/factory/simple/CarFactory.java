package factory.simple;

/**
 * 汽车工厂
 */
public class CarFactory {
    public  static Car getCar(String car) {
        if (car.equals("五菱")) {
            return new Wuling();
        } else if (car.equals("大众")) {
            return new Dazhong();
        } else {
            return null;
        }

    }
}
