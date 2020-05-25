package builder.director;

/**
 * 建造者模式：将一个复杂对象的构建与他的表现分离 ，使同样的构建过程可以有不同的表现形式
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        Product build = director.build(new Worker());
        System.out.println(build.toString());

    }

}
