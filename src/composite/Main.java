package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * <p>
 * 解决： 将对象组合成树形结构以表示“部分-整体”的层次结构。组合模式使得用户可以使用一致的方法操作单个对象和组合对象。
 */
public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        Node c11 = new BranchNode("c11");
        Node c12 = new BranchNode("c12");
        BranchNode b21 = new BranchNode("section21");
        Node c211 = new BranchNode("c211");
        Node c212 = new BranchNode("c212");

        root.add(chapter1);
        root.add(chapter2);
        chapter1.add(c11);
        chapter1.add(c12);
        chapter2.add(b21);
        b21.add(c211);
        b21.add(c212);
        tree(root, 0);
    }

    public static void tree(Node node, int deep) {
        for (int i = 0; i < deep; i++) {
            System.out.print("-- ");

        }
        node.p();
        if (node instanceof BranchNode) {
            for (Node n : ((BranchNode) node).nodes) {
                tree(n, deep + 1);
            }
        }
    }

}

/**
 * 模拟目录和文件层加
 */
abstract class Node {
    abstract public void p();
}

//没有子节点


class BranchNode extends Node {
    List<Node> nodes = new ArrayList<>();

    String name;

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    public void p() {
        System.out.println(name);
    }

    public void add(Node node) {
        nodes.add(node);
    }
}
