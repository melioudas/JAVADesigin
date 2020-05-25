package flyweight;

import java.util.HashMap;

/**
 * 享元模式
 * <p>
 * 主要用于减少创建对象的数量，以减少内存占用和提高性能
 * <p>
 * 常见的如常量池，连接池 。池化思想
 * <p>
 * 例子:来个地图种大树！
 */
public class Main {
    public static void main(String[] args) {
        DaTree t1=DaTreeFactory.getTree("杨树");
        DaTree t2=DaTreeFactory.getTree("杨树");
        DaTree t3=DaTreeFactory.getTree("杨树");
        DaTree t4=DaTreeFactory.getTree("杨树");
        DaTree t5=DaTreeFactory.getTree("柳树");
        System.out.println("实际的大树对象数量： "+DaTreeFactory.trees.size());

    }
}

class DaTreeFactory {
    static HashMap<String, DaTree> trees = new HashMap<>();

   static DaTree getTree(String name) {
        DaTree t = trees.get(name);
        if (t != null) {
            return t;
        }
        DaTree tree = new DaTree(name);
        trees.put(name, tree);
        return tree;
    }
}

class DaTree {
    String name;

    public DaTree(String name) {
        this.name = name;
    }
}