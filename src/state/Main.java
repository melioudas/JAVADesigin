package state;

/**
 * 状态模式
 * 行为随着状态的改变而改变
 * <p>
 * 状态是实现类，行为是具体方法
 * <p>
 * 抓娃娃机案例
 * 状态：1.待机 2.运行
 * 行为：0.投币 1.退币 2.开始抓娃娃
 */
public class Main {
    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.disc();
        machine.play();
        machine.backCoin();
        machine.addCoin();
        machine.backCoin();
        machine.addCoin();
        machine.disc();
        machine.play();
        machine.backCoin();
    }
}

//状态抽象，其中方法为行为
interface State {
    void addCoin();

    void backCoin();

    void play();

    void disc();
}

//待机状态
class ReadyState implements State {
    //保存machine ，为了根据行为修改状态
    Machine machine;

    public ReadyState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void addCoin() {
        System.out.println("已投币！");
        //直接修改娃娃机状态
        machine.setState(machine.runingState);
    }

    @Override
    public void backCoin() {
        System.out.println("没投币还想白嫖币？！请先投币！");
    }

    @Override
    public void play() {
        System.out.println("没投币还想玩？！请先投币！");
    }

    @Override
    public void disc() {
        System.out.println("待机状态");
    }
}

//运行状态
class RuningState implements State {
    Machine machine;

    public RuningState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void addCoin() {
        System.out.println("运行中，请不要投币！");
    }

    @Override
    public void backCoin() {
        System.out.println("退币！");
        machine.setState(machine.readyState);
    }

    @Override
    public void play() {
        System.out.println("玩上了 抓到一只！");
        machine.setState(machine.readyState);
    }

    @Override
    public void disc() {
        System.out.println("运行状态");
    }
}

//娃娃机-这里实现State完全是为了编程简单，直接重写方法了
class Machine implements State {
    private State state;
    ReadyState readyState;
    RuningState runingState;

    public Machine() {
        readyState = new ReadyState(this);
        runingState = new RuningState(this);
        //初始状态设成待机
        state = readyState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void addCoin() {
        state.addCoin();
    }

    @Override
    public void backCoin() {
        state.backCoin();
    }

    @Override
    public void play() {
        state.play();
    }

    @Override
    public void disc() {
        state.disc();
    }
}
