package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 * <p>
 * 定义对象间的一对多的依赖关系，当一个对象的状态发生变化时，所有依赖于它的对象对得到通知并被自动更新
 * <p>
 * 解决问题：目标对象的状态发生改变，所有观察者都将得到通知
 * <p>
 * JDK已经实现了观察者模式，Observer接口指定观察者，Observable 类，为被观察者父类
 * <p>
 * 例子：1.手动实现 LOL看一眼大龙，大龙为被观察者，我方队友为观察者
 * 2.引用JDK实现
 */
public class Main {
    public static void main(String[] args) {
        BOOS dalong = new BOOS();
        OurObserver niu = new OldMener();
        OurObserver yasuo = new HapperMan();
        dalong.add(niu);
        dalong.add(yasuo);
        dalong.appear();
        //使用jdk形式
        Observer Js=new JianSheng();
        Observer St=new Shitou();
        XiaoLong Xl=new XiaoLong();
        Xl.addObserver(Js);
        Xl.addObserver(St);
        Xl.aaa();
    }
}

//定义我方观察者
interface OurObserver {
    void update();  //我方观察者行为
}

//定义具体观察者
//老牛
class OldMener implements OurObserver {
    @Override
    public void update() {
        System.out.println("俺老牛看到大龙了，大龙安全！");
    }
}

//亚索
class HapperMan implements OurObserver {
    @Override
    public void update() {
        System.out.println("快乐风男看到大龙了，我要干它！");
    }
}

//定义被观察者抽象 --直接实现了通知方法，可交由子类实现
class OurOvserable {
    List<OurObserver> observers = new ArrayList<>();

    void add(OurObserver observer) {
        observers.add(observer);
    }

    void remove(OurObserver observer) {
        observers.remove(observer);
    }

    void notifyObservers() {
        for (OurObserver observer : observers) {
            observer.update();
        }
    }
}

class BOOS extends OurOvserable {
    void appear() {
        System.out.println("男爵一出，万民臣服！");
        notifyObservers();
    }
}

//直接使用jdk实现，这把看小龙了
class JianSheng implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("无极之道，直斩小龙！");
    }
}

class Shitou implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("坚如磐石，喷吧小龙龙！");
    }
}

class XiaoLong extends Observable {
    public void aaa() {
        System.out.println("小龙闪亮登场!");
        setChanged();
        notifyObservers();
    }
}