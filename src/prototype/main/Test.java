package prototype.main;

import java.util.ArrayList;

/**
 * 原型模式 <=> 克隆模式  <=>多莉克隆羊
 * <p>
 * 解决: 用于创建重复的对象，同时又能保证性能，当直接创建对象的代价比较大时，则采用这种模式
 * <p>
 * 注意: 当需要拷贝的对象中有引用类型时，需要使用深拷贝。
 * 深拷贝实现方式：
 * 1.序列化和反序列化 --相对复杂
 * 2.在clone方法中给引用类型赋值为引用的拷贝，注意理解。
 * <p>
 * <p>
 * 情景演示：
 * 在克隆羊多莉的基础上，克隆出多莉二号，注意当改变多莉的朋友时，多莉二号的朋友不应该被改变，应使用深拷贝
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList dliFriends = new ArrayList();
        dliFriends.add("小花");
        dliFriends.add("小白");

        SheepDli dli = new SheepDli("多莉", dliFriends, "0-1-2-3-4-5");
        System.out.println(dli.toString() + " hash:" + dli.hashCode());
        //再来一只羊
        Sheep dli2 = (Sheep) dli.clone();
        System.out.println(dli2.toString() + " hash:" + dli2.hashCode());
        dliFriends.add("小绿");

        System.out.println(dli.toString());
        System.out.println(dli2.toString());
    }
}

//羊
interface Sheep {

}

//多莉绵羊
class SheepDli implements Cloneable, Sheep {
    private String name;    //名字
    private ArrayList<String> friends;  //动物伙伴
    private Object DNA;  //复杂的DNA

    public SheepDli(String name, ArrayList<String> friends, Object DNA) {
        this.name = name;
        this.friends = friends;
        this.DNA = DNA;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SheepDli o = (SheepDli) super.clone();
        o.setFriends((ArrayList<String>) friends.clone());
        return o;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }

    public Object getDNA() {
        return DNA;
    }

    public void setDNA(Object DNA) {
        this.DNA = DNA;
    }

    @Override
    public String toString() {
        return "SheepDli{" +
                "name='" + name + '\'' +
                ", friends=" + friends +
                ", DNA=" + DNA +
                '}';
    }
}
