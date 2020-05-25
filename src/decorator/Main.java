package decorator;

/**
 * 装饰者模式
 * <p>
 * 解决问题：扩展一个类的功能，或给一个类添加附加职责
 *
 * 优点：
 *  1.不改变原有对象的情况下给一个对象扩展功能
 *  2.使用不同的组合可以实现不同的效果
 *  3.符合开闭原则
 */
public class Main {
    public static void main(String[] args) {
        Component component = new LvJing(new MeiYan(new ConcrereComponent()));
        component.operation();
    }
}

/**
 * 案例： 给原始相机添加功能。美颜、滤镜。
 */

//相机抽象
interface Component {
    void operation();
}

//相机=>将要扩展的类
class ConcrereComponent implements Component {
    @Override
    public void operation() {
        System.out.println("拍照");
    }
}

//添加美颜
class MeiYan implements Component {
    //引入相机抽象
    Component component;

    //构造给相机赋值
    public MeiYan(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
        System.out.println("美颜");
    }
}

//添加滤镜
class LvJing implements Component {
    //引入相机抽象
    Component component;

    //构造给相机赋值
    public LvJing(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
        System.out.println("滤镜");
    }
}