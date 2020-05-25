package templateMethod;

/**
 * 模板方法《=》钩子函数
 * <p>
 * 定义一个通用的算法骨架，将实现推迟到子类实现
 * 例子： 来个做饭的抽象类，至于怎么焖饭怎么炒菜，用户自己实现
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
      XiaoMing xm=XiaoMing.class.newInstance();
      xm.cook();
    }

}

//做饭
abstract class Cook {
    final void cook() {
        menfan();
        chaocai();
    }
    //焖饭
    abstract void menfan();
    //炒菜
    abstract void chaocai();
}

class XiaoMing extends Cook {
    @Override
    void menfan() {
        System.out.println("小明闷大米饭。。。");
    }
    @Override
    void chaocai() {
        System.out.println("小明炒个柿子鸡蛋。。。");
    }
}