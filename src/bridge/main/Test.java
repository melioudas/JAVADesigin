package bridge.main;

/**
 * 桥接模式
 * 定义：将抽象部分与它实现部分分离，使它们都可以独立地变化。
 * <p>
 * 把两个不同维度的东西桥接起来
 * <p>
 * 解决：桥接模式是一种很实用的结构型设计模式，如果软件系统中某个类存在两个独立变化的维度，
 * 通过该模式可以将这两个维度分离出来，使两者可以独立扩展，让系统更加符合“单一职责原则”
 * <p>
 * 举例：手机和内存卡的故事
 * 想获得  华为手机--4G  华为手机--8G  小米手机--4G  小米手机--8G
 * 使用桥接模式 使手机品牌与内存组合，实现松耦合
 * <p>
 * 关键在于谁包含谁，手机包含各种颜色
 * <p>
 * 精髓：使用组合代替继承，注意组合得是抽象
 */
public class Test {
    public static void main(String[] args) {
        Phone phone = new HuaWei();
        phone.setMemory(new Menory4G());
        phone.init();
    }
}

//1.内存卡抽象
interface Memory { 
    //加载内存
    void loadMemory();
}

//2.4G内存卡
class Menory4G implements Memory {

    @Override
    public void loadMemory() {
        System.out.println("加载4G内存卡");
    }
}

//3.手机抽象 《=》桥接的桥
abstract class Phone {
    //将抽象与实现分离
    Memory memory;

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    //开机
    abstract void init();
}

class HuaWei extends Phone {

    @Override
    void init() {
        memory.loadMemory();
        System.out.println("华为手机开机");
    }
}


