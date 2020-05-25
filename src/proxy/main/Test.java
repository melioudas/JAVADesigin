package proxy.main;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * <p>
 * 解决：两个类不能直接访问，加个代理
 * <p>
 * 场景举例：在代码前后加日志，查看代码执行时间，AOP
 * <p>
 * 静态代理写外层了
 * <p>
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //来一个真实对象
        HouseOwner houseOwner = HouseOwner.class.newInstance();
        ProxyinvocationHandler ph = new ProxyinvocationHandler(houseOwner);
        Rent rent = (Rent) ph.getProxy();
        rent.rent();
    }
}

//租房
interface Rent {
    void rent();
}

//房东
class HouseOwner implements Rent {
    @Override
    public void rent() {
        System.out.println("房东租房。。。");
    }
}

//动态代理
class ProxyinvocationHandler implements InvocationHandler {
    Rent rent;

    public ProxyinvocationHandler(Rent rent) {
        this.rent = rent;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用代理类。。。");
        method.invoke(rent, args);
        return null;
    }
}