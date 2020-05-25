package proxy;

/**
 * 代理模式--AOP核心
 * <p>
 * 1.静态代理
 * 1.1 接口
 * 1.2 真实角色
 * 1.3 代理角色
 * 1.4 客户端
 * <p>
 * <p>
 * 2.动态代理
 */
public class Main {
    public static void main(String[] args) {
       //静态代理
        Proxy proxy=new Proxy(new HouseOwner());
        proxy.Rent();
    }
}

//租房抽象
interface Rent {
    void Rent();
}

//房东
class HouseOwner implements Rent {
    @Override
    public void Rent() {
        System.out.println("房东------^-^-----租房");
    }
}

//中介  --    代理
class Proxy implements Rent {
    private HouseOwner houseOwner;

    public Proxy() {

    }

    public Proxy(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    @Override
    public void Rent() {
        System.out.println("中介带你看房子");
        System.out.println("中介带你签合同");
        houseOwner.Rent();
        System.out.println("中介帮你搬家");
    }
}
