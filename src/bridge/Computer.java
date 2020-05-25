package bridge;

/**
 * 电脑类
 */
public abstract class Computer {
    //组合品牌
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;

    }

    public void info() {
        brand.info();
    }

}


class Desktop extends Computer {

    public Desktop(Brand brand) {
        super(brand);
    }

    public void info() {
        super.info();
        System.out.println("台式机");
    }
}

class Laptop extends Computer {

    public Laptop(Brand brand) {
        super(brand);
    }

    public void info() {
        super.info();
        System.out.println("笔记本");
    }
}