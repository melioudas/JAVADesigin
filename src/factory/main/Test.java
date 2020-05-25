package factory.main;

/**
 * 工厂模式：简单工厂、工厂方法、抽象工厂
 * <p>
 * 描述：
 * 在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象
 * <p>
 * 解决：
 * 简单工厂：有一个工厂类，负责根据提供的信息创建对象 ，并非设计模式
 * 工厂方法：对简单工厂的改进，不用传递要构造的参数了，多个工厂了，分别创建对象
 * 抽象工厂：程序需要处理不同系列的相关产品，不希望它依赖于这些产品的具体类时。
 * <p>
 * 工厂方法和抽象工厂区别就在于前者是产生一个对象而后者是可以产生一系列的对象
 */
public class Test {
    public static void main(String[] args) {
        //使用工厂方法
        MouseFactory mouseFactory = new HpFactory();
        Mouse mouse = mouseFactory.createMouse();
        mouse.click();
        System.out.println("========抽象工厂========");
        //使用抽象工厂
        AbstractFactory factory = new AppleFactory();
        Mouse mouse1 = factory.createMouse();
        KeyBoard keyBoard = factory.createKeyBoard();
        mouse1.click();
        keyBoard.click();
    }
}

//工厂模式

//鼠标工厂
interface MouseFactory {
    Mouse createMouse();
}

//鼠标
interface Mouse {
    void click();
}

//惠普工厂
class HpFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}

//惠普鼠标
class HpMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("HP鼠标。。。");
    }
}

//抽象工厂模式    生产鼠标和键盘，即两件以上的产品
interface AbstractFactory {
    Mouse createMouse();

    KeyBoard createKeyBoard();
}

//和上面冲突了
//interface Mouse{
//    void click();
//}
interface KeyBoard {
    void click();
}

//苹果鼠标
class AppleMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Apple 鼠标。。。");
    }
}

//苹果键盘
class AppleKeyBoard implements KeyBoard {
    @Override
    public void click() {
        System.out.println("Apple 键盘。。。");
    }
}

class AppleFactory implements AbstractFactory {
    @Override
    public Mouse createMouse() {
        return new AppleMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new AppleKeyBoard();
    }
}








