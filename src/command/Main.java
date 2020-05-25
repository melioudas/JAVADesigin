package command;

/**
 * 命令模式
 * <p>
 * 命令模式，“封装了方法调用细节”，以解耦请求者与执行者
 * <p>
 * 举例： 顾客点菜，服务员开菜单给厨师，这里的菜单就可以理解成命令的封装对象
 */
public class Main {
    public static void main(String[] args) {
        Invoke invoke = new Invoke(new NoodleCommand(new RecevierNoodleCooker()));
        invoke.NoodleCommand();
        invoke.NoodleBack();
    }
}

//命令抽象
interface Command {
    //统一执行方法
    void execute();

    //退菜
    void undo();
}

//做面条的命令
class NoodleCommand implements Command {
    RecevierNoodleCooker recevierCooker;

    public NoodleCommand(RecevierNoodleCooker recevierCooker) {
        this.recevierCooker = recevierCooker;
    }

    @Override
    public void execute() {
        recevierCooker.cook();
    }

    @Override
    public void undo() {
        recevierCooker.unCook();
    }
}

//发令者--服务员
class Invoke {
    private Command command;

    public Invoke(Command command) {
        this.command = command;
    }

    public void NoodleCommand() {
        command.execute();
    }

    public void NoodleBack() {
        command.undo();
    }
}

class RecevierNoodleCooker {
    public void cook() {
        System.out.println("面条厨师，做面条");
    }

    public void unCook() {
        System.out.println("退菜了");
    }
}