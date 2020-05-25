package adapter.main;


import adapter.Adapter;

import java.io.*;

/**
 * 适配器模式
 * <p>
 * 当一个不能直接访问另一个类的时候，中间加一个转换
 * <p>
 * 举例：IO流和手机充电
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //典型操作：IO流
//        FileInputStream fis = new FileInputStream("c:/test.txt");
//        InputStreamReader isr = new InputStreamReader(fis);
//        BufferedReader br = new BufferedReader(isr);
//        String line = br.readLine();
        //手机充电
        Phone phone = new Phone();
        phone.chongdian(new ChongDianqi(new V220()));
    }
}

//220V电压
class V220 {
    public int load() {
        System.out.println("输出220V的电压");
        return 220;
    }
}

//5V电压接口
interface V5 {
    int loadV5();
}

//手机充电
class Phone {
    void chongdian(V5 v5) {
        System.out.println("V5 电压充电中。。。。。");
    }
}

//我国不提供5V的电压 5V的电压得从220V获取
class ChongDianqi implements V5 {
    V220 v220;

    public ChongDianqi(V220 v220) {
        this.v220 = v220;
    }

    @Override
    public int loadV5() {
        return v220.load() / 22;
    }
}
