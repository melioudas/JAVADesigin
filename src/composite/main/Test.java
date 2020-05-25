package composite.main;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * <p>
 * 解决：专为树形（层级）结构设计
 * <p>
 * 实例：员工里面有员工(小弟)，学校里面有分校，文件夹里面有文件夹，子子孙孙无穷尽也，有套娃的感觉
 */
public class Test {
    public static void main(String[] args) {
        Employee Leader = new Employee("汉帝");
        Employee caocao = new Employee("曹操");
        Employee liubei = new Employee("刘备");
        Employee guanyu = new Employee("关羽");
        Employee xiahoudun = new Employee("夏侯惇");
        Employee guanxing = new Employee("关兴");
        Employee jiaowei = new Employee("校尉");
        Leader.addXiaodi(caocao);
        Leader.addXiaodi(liubei);
        liubei.addXiaodi(guanyu);
        guanyu.addXiaodi(guanxing);
        guanxing.addXiaodi(jiaowei);
        caocao.addXiaodi(xiahoudun);
        tree(Leader, 0);
    }

    static void tree(Employee employee, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("——");
        }
        System.out.println(employee.name);
        for (Employee ee : employee.xiaodi) {
            tree(ee, depth + 1);
        }

    }
}

//员工类
class Employee {
    //员工姓名
    String name;
    //小弟   -----    核心
    List<Employee> xiaodi;

    public Employee(String name) {
        this.name = name;
        xiaodi = new ArrayList<>();
    }

    public void addXiaodi(Employee ee) {
        xiaodi.add(ee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getXiaodi() {
        return xiaodi;
    }

    public void setXiaodi(List<Employee> xiaodi) {
        this.xiaodi = xiaodi;
    }
}