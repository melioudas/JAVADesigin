package chain;

/**
 * 责任链模式
 * <p>
 * 定义：职责链将请求的发送者和请求的处理者解耦
 * 职责链上的处理者负责处理请求，客户只需要将请求发送到职责链上即可，无须关心请求的处理细节和请求的传递
 * <p>
 * 举例：学生请假老师审批，老师审批不了找主任，主任审批不了找校长
 */
public class Main {
    public static void main(String[] args) {
       //学生请假
        DepartmentHead departmentHead=new DepartmentHead();
        ClassAdviser adviser=new ClassAdviser();
        adviser.setNext(departmentHead);
        adviser.handler(5);
    }
}

//领导抽象类 --思路：如果无权处理就将假条交给下一位具体处理者，直到最后
abstract class Leader {
    private Leader next;

    public Leader getNext() {
        return next;
    }

    public void setNext(Leader next) {
        this.next = next;
    }

    abstract public void handler(int day);
}

//班主任
class ClassAdviser extends Leader {
    @Override
    public void handler(int day) {
        if (day < 3) {
            System.out.println("班主任 准假！");
        } else {
            if (getNext() != null) {
                getNext().handler(day);
            } else System.out.println("请假天数过多，没人能批");

        }
    }
}

//主任
class DepartmentHead extends Leader {

    @Override
    public void handler(int day) {
        if (day < 8) {
            System.out.println("系主任 准假！");
        } else {
            if (getNext() != null) {
                getNext().handler(day);
            } else System.out.println("请假天数过多，没人能批");

        }
    }
}
