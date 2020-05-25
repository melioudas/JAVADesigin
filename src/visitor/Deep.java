package visitor;

/**
 * 访问者模式 -又一层理解
 * <p>
 * 解决静态分派的问题，即使解决函数重载的的问题
 */
public class Deep {
    public static void main(String[] args) {
        //静态分派  重载
        Horse wh = new WhiteHorse();
        Horse bh = new BlackHorse();
        Mozi mozi = new Mozi();
        mozi.ride(wh);
        mozi.ride(bh);
        //动态分派  重写
        Horse whh = new WhiteHorse();
        whh.eat();
    }
}

//来个墨子骑马，骑白马 ，骑黑马
interface Per {
    public void ride(Horse h);

    public void ride(WhiteHorse wh);

    public void ride(BlackHorse bh);
}

class Mozi implements Per {
    public void ride(Horse h) {
        System.out.println("骑马");
    }

    public void ride(WhiteHorse wh) {
        System.out.println("骑白马");
    }

    public void ride(BlackHorse bh) {
        System.out.println("骑黑马");
    }
}

class Horse {
    public void eat() {
        System.out.println("马吃草");
    }
}

class WhiteHorse extends Horse {
    @Override
    public void eat() {
        System.out.println("白马吃草");
    }
}

class BlackHorse extends Horse {

    @Override
    public void eat() {
        System.out.println("黑马吃草");
    }
}