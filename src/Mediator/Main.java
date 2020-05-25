package Mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式
 * <p>
 * 用来降低多个对象和类之间的通信复杂度。该模式提供一个中介类，该类通常处理不同类之间的通信，并支持松耦合。
 * 和门面模式相像，门面模式解决对外的调用，中介者模式解决对内的调用
 * <p>
 * 总滴来说，解决服务间调用！
 * <p>
 * 举例：来个内部的聊天群，中间服务器为中介
 */
public class Main {
    public static void main(String[] args) {
        Mediator qq = new QQ();
        Friend ming = new XiaoMing();
        Friend hong = new Hong();
        qq.login(ming);
        qq.login(hong);
        ming.send("晚上打团啊？");
        hong.send("干啊 奥里给啊！");

    }
}

//中介抽象
interface Mediator {
    void login(Friend friend);    //登记

    void replay(Friend friend);   //转发
}

//中介QQ
class QQ implements Mediator {
    private List<Friend> friends = new ArrayList<Friend>();

    @Override
    public void login(Friend friend) {
        if (!friends.contains(friend)) {
            friends.add(friend);
            friend.setMediator(this);
        }
    }

    @Override
    public void replay(Friend friend) {

        for (Friend f : friends) {
            if (!f.equals(friend)) {
                f.receive(friend.getMsg());
            }


        }
    }
}

//同事抽象
abstract class Friend {
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    //接收消息
    abstract void receive(String str);

    //发送消息
    abstract void send(String str);
}

//具体同事
class XiaoMing extends Friend {

    @Override
    void receive(String str) {
        msg = "";
        System.out.println("小明接收到了消息:" + str);
    }

    @Override
    void send(String str) {
        this.setMsg(str);
        mediator.replay(this);
    }
}

class Hong extends Friend {

    @Override
    void receive(String str) {
        msg = "";
        System.out.println("红红接收到了消息:" + str);
    }

    @Override
    void send(String str) {
        this.setMsg(str);
        mediator.replay(this);
    }
}


