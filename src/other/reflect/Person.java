package other.reflect;


/**
 * Person类用于反射实验
 */
public class Person {

    public String a;
    protected String b;
    String c;
    private String d;


    public String name;

    private int age;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        System.out.println("get le ");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String eat() {
        System.out.println("啥也没吃着");
        return "eat";
    }

    public String eat(String food) {
        System.out.println("吃：" + food);
        return food;
    }
}
