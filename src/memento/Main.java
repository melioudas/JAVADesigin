package memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式
 * <p>
 * 保存一个对象的某个状态，以便在适当的时候恢复
 * <p>
 * 解决问题:实现一种恢复模式
 * <p>
 * 举例：老师叫同学答问题，叫一个刚才答过的同学，相当于ctrl + z
 */
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("小明");
        Student student2 = new Student();
        student2.setName("小红");
        Student student3 = new Student();
        student3.setName("小兰");
        Student student4 = new Student();
        student4.setName("小绿");
        Student student5 = new Student();
        student5.setName("小粉");

        Manager manager=new Manager();
        manager.add(student1.saveStudentMemento());
        manager.add(student2.saveStudentMemento());
        manager.add(student3.saveStudentMemento());
        manager.add(student4.saveStudentMemento());
        manager.add(student5.saveStudentMemento());

        student1.loadFormMemento(manager.getList().get(1));
        System.out.println(student1.getName());
    }
}

//创建备忘录
class Memento {
    String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

//实体 需要保存状态的类--笔记本
class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Memento saveStudentMemento() {
        return new Memento(name);
    }

    public void loadFormMemento(Memento memento) {
        name = memento.getState();
    }
}

//管理备忘录类
class Manager {
    List<Memento> list = new ArrayList<>();

    public void add(Memento memento) {
        list.add(memento);
    }

    public List<Memento> getList() {
        return list;
    }
}