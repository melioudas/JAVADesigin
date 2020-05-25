package builder.main;


/**
 * 建造者模式 ---针对实例化时属性组合经常变化
 * <p>
 * 定义： 将一个复杂对象的构建与其表现分离，使得同样的构建过程可以构建不同的表示
 * <p>
 * 主要解决：主要解决在软件系统中，有时候面临着"一个复杂对象"的创建工作，其通常由各个部分的子对象用一定的算法构成；
 * 由于需求的变化，这个复杂对象的各个部分经常面临着剧烈的变化，但是将它们组合在一起的算法却相对稳定。
 * <p>
 * 何时使用：一些基本部件不会变，而其组合经常变化的时候。
 * <p>
 * 实现：1.没有Director形式，好处是使用时指定顺序灵活性高
 * 2.有Director director层实现控制Build的顺序
 * <p>
 * 实例：按照理解，针对实例化组合的变化，场景我们设在一个小饭馆，每个客人点的餐都不一样，那么饭馆应如何满足顾客？
 */
public class Test {
    public static void main(String[] args) {
        //简单建造者使用
        Computer.Build c = new Computer.Build("AOC显示器", "联想机箱").addJianpan("机械键盘").addShubiao("雷蛇鼠标");
        System.out.println(c.computer.toString());

        //经典的建造者
        Director director = new Director();
        Computer cc = director.getComper(new AppleBuild("大机箱", "海尔显示器"), "黑轴键盘", "牧马人鼠标");
        System.out.println(cc.toString());

        //神厨 小福贵
        BuildChushi chushi=new Xiaofugui();
        Caixi caixi=chushi.zhaji().jianniupai().menfan().zouCai();
        System.out.println(caixi.toString());

        //神厨二号
        BuildChushi xiaogouzi=new Xiaofugui();
        Caixi caixi1=xiaogouzi.jianniupai().menfan().kaoyu().zouCai();
        System.out.println(caixi1.toString());
    }

}

//1.简化的建造者模式，以组装电脑为例
class Computer {

    private String Xianshiqi;     //必须
    private String Jixiang;       //必须
    private String Jianpan;       //可选
    private String Shubiao;       //可选

    public Computer() {

    }

    public Computer(String xianshiqi, String jixiang) {
        Xianshiqi = xianshiqi;
        Jixiang = jixiang;
    }

    //简单使用
    static class Build {
        Computer computer = new Computer();

        public Build(String xianshiqi, String jixiang) {
            computer.setXianshiqi(xianshiqi);
            computer.setJixiang(jixiang);
        }

        public Build addJianpan(String jianpan) {
            computer.setJianpan(jianpan);
            return this;
        }

        public Build addShubiao(String shubiao) {
            computer.setShubiao(shubiao);
            return this;
        }
    }

    public void setXianshiqi(String xianshiqi) {
        Xianshiqi = xianshiqi;
    }

    public void setJixiang(String jixiang) {
        Jixiang = jixiang;
    }

    public void setJianpan(String jianpan) {
        Jianpan = jianpan;
    }

    public void setShubiao(String shubiao) {
        Shubiao = shubiao;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "Xianshiqi='" + Xianshiqi + '\'' +
                ", Jixiang='" + Jixiang + '\'' +
                ", Jianpan='" + Jianpan + '\'' +
                ", Shubiao='" + Shubiao + '\'' +
                '}';
    }
}


//2.标准的建造者模式  复用上面的Computer，忽略里面得静态内部类

//class Computer
//建造者
interface Build {
    Build setJianpan(String jp);

    Build setShubiao(String sb);

    Computer getComputer();
}

//苹果建造者
class AppleBuild implements Build {
    Computer computer = new Computer();

    public AppleBuild(String jx, String xsq) {
        computer.setJixiang(jx);
        computer.setXianshiqi(xsq);
    }

    @Override
    public Build setJianpan(String jp) {
        computer.setJianpan(jp);
        return this;
    }

    @Override
    public Build setShubiao(String sb) {
        computer.setShubiao(sb);
        return this;
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

class Director {
    public Computer getComper(Build build, String jp, String sb) {
        //按照先键盘后鼠标的顺序，缺点是不灵活
        return build.setJianpan(jp).setShubiao(sb).getComputer();
    }
}

//饭馆案例-》自理解
//1.菜品类
class Caixi {
    private String mifan;   //米饭
    private String yu;      //鱼肉
    private String ji;      //鸡
    private String zhu;     //猪肉
    private String niupai;  //牛排

    public void setMifan(String mifan) {
        this.mifan = mifan;
    }

    public void setYu(String yu) {
        this.yu = yu;
    }

    public void setJi(String ji) {
        this.ji = ji;
    }

    public void setZhu(String zhu) {
        this.zhu = zhu;
    }

    public void setNiupai(String niupai) {
        this.niupai = niupai;
    }

    @Override
    public String toString() {
        return "Caixi{" +
                "mifan='" + mifan + '\'' +
                ", yu='" + yu + '\'' +
                ", ji='" + ji + '\'' +
                ", zhu='" + zhu + '\'' +
                ", niupai='" + niupai + '\'' +
                '}';
    }
}

//2.厨师类,做菜抽象
interface BuildChushi {
    BuildChushi menfan();

    BuildChushi kaoyu();

    BuildChushi zhaji();

    BuildChushi chaozhurou();

    BuildChushi jianniupai();

    Caixi zouCai();
}

//3.神厨小福贵
class Xiaofugui implements BuildChushi {
    //将做的一桌菜
    Caixi caixi;

    public Xiaofugui() {
        //开始做菜
        caixi = new Caixi();
    }

    @Override
    public BuildChushi menfan() {
        System.out.println("大米饭");
        caixi.setMifan("大米饭");
        return this;
    }

    @Override
    public BuildChushi kaoyu() {
        System.out.println("烤鱼");
        caixi.setYu("烤鱼");
        return this;
    }

    @Override
    public BuildChushi zhaji() {
        System.out.println("炸鸡");
        caixi.setJi("炸鸡");
        return this;
    }

    @Override
    public BuildChushi chaozhurou() {
        System.out.println("小炒肉");
        caixi.setZhu("小炒肉");
        return this;
    }

    @Override
    public BuildChushi jianniupai() {
        System.out.println("煎牛排");
        caixi.setNiupai("煎牛排");
        return this;
    }

    @Override
    public Caixi zouCai() {
        return caixi;
    }
}
