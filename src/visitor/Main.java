package visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 访问者模式
 * <p>
 * 定义：将作用于某种数据结构中的各元素的操作分离出来封装成独立的类。使其在不改变数据结构的前提下可以添加作用于这些元素的新的操作
 * 为数据结构中的每个元素提供多种访问方式。它对数据的操作与数据结构进行分离。
 * <p>
 * 举例：艺术公司利用“铜”可以设计出铜像，利用“纸”可以画出图画；造币公司利用“铜”可以印出铜币，利用“纸”可以印出纸币。
 * 对“铜”和“纸”这两种元素，两个公司的处理方法不同，所以该实例用访问者模式来实现比较适合。
 */
public class Main {
    public static void main(String[] args) {
        Setmateial os = new Setmateial();
        os.add(new Cuprum());
        os.add(new Paper());
        Company visitor1 = new ArtCompany();
        Company visitor2 = new Mint();
        System.out.println(os.accept(visitor1));
        System.out.println(os.accept(visitor2));
        //

        Company visitor3 = new ArtCompany();
        Material p=new Paper();
        System.out.println(visitor3.create(p) );
    }
}

//抽象访问者：公司
interface Company {
    String create(Material element);

    String create(Paper element);

    String create(Cuprum element);
}

//艺术公司
class ArtCompany implements Company {
    @Override
    public String create(Material element) {
        return "--";
    }

    @Override
    public String create(Paper element) {
        return "艺术公司使用纸张造了一幅画";
    }

    @Override
    public String create(Cuprum element) {
        return "艺术公司使用铜造了个铜像";
    }


}

//造币公司
class Mint implements Company {
    @Override
    public String create(Material element) {
        return "--";
    }

    @Override
    public String create(Paper element) {
        return "造币公司使用纸造了一张100元";
    }

    @Override
    public String create(Cuprum element) {
        return "造币公司使用铜造了一枚5角钱";
    }


}

//材料
interface Material {
    String accept(Company visitor);
}

//纸
class Paper implements Material {

    @Override
    public String accept(Company visitor) {
        return (visitor.create(this));
    }
}

//铜
class Cuprum implements Material {

    @Override
    public String accept(Company visitor) {
        return visitor.create(this);
    }
}

//对象结构角色：材料集
class Setmateial {
    private List<Material> list = new ArrayList<>();

    public String accept(Company visitor) {
        Iterator<Material> i = list.iterator();
        String tep = "";
        while (i.hasNext()) {
            tep += ((Material) i.next()).accept(visitor) + " ";
        }
        return tep;
    }

    public void add(Material element) {
        list.add(element);
    }

    public void remove(Material element) {
        list.remove(element);
    }
}
