package adapter;

/**
 * 真正的适配器
 */
//1.如果继承了WangXian则是类适配器
public class Adapter implements NetToUsb {
    //2.对象适配器
    WangXian wangXian;
    //3.如果使用抽象类实现一个接口 然后使用时直接使用抽象类，则为接口适配器


    public Adapter(WangXian wangXian) {
        this.wangXian = wangXian;
    }

    @Override
    public void handleRquest() {
        wangXian.request();
    }
}
