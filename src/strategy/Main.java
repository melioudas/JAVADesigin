package strategy;

/**
 * 策略模式
 * 定义：    一个类的行为或其算|法可以在运行时更改
 * 理解：  在不同条件下，方法有不同的实现方式
 * 组成：
 * 1.抽象策略  Strategy
 * 2.具体策略  ConcreteStrategy
 * 3.环境      Context
 * <p>
 * 举例：实现加减乘除
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("情景再现，老师给了小明同学两个数字 9 和 1");
        Context c = new Context(new OperationAdd());
        int num = c.operation(9, 1);
        System.out.println("小明算加法：" + num);

        Context c2 = new Context(new OperationSubtract());
        int num2 = c2.operation(9, 1);
        System.out.println("小明算减法：" + num2);
    }
}

//策略抽象
interface Strategy {
    int doOperation(int num1, int num2);
}

//加法
class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

//减法
class OperationSubtract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

//环境
class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int operation(int a, int b) {
        return strategy.doOperation(a, b);
    }
}
