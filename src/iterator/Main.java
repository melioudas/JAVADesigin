package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式
 * <p>
 * 提供一种方法顺序访问一个聚会对象中各个元素，而又无需暴漏该对象的内部表示
 * <p>
 * 举例：书店查看归还的书
 * <p>
 * 核心：迭代器实现next和hasNext
 */
public class Main {
    public static void main(String[] args) {
        //玩一把
        Aggregate books = new BookStore();
        books.add("深入了解java虚拟机");
        books.add("斗罗大陆");
        books.add("Spring从入门到精通");
        books.add("设计模式");
        books.add("数据结构");
        Iterator bt = books.getIterator();
        while (bt.hasNext()) {
            Object oo = bt.next();
            System.out.println(oo.toString());
        }

    }
}

//迭代器接口
interface Iterator {
    Boolean hasNext();

    Object next();
}

//迭代器实现
class BookIterator implements Iterator {
    private List<Object> list = null;

    public BookIterator(List<Object> list) {
        this.list = list;
    }

    int index = -1;

    @Override
    public Boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        return list.get(++index);
    }
}

//聚合
interface Aggregate {
    void add(Object o);

    Iterator getIterator();
}

//聚合实现，图书馆
class BookStore implements Aggregate {
    private List<Object> list = new ArrayList<>();

    @Override
    public void add(Object o) {
        list.add(o);
    }

    @Override
    public Iterator getIterator() {
        return new BookIterator(this.list);
    }
}