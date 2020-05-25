package visitor;

/**
 * test
 *
 * <p><a href="test.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:afteryuan@gmail.com">Spires</a>
 * @version 1.0
 */
public class test {

}

class Test {

    public static void main (String[] args){
        Father f = new Father();
        Father s = new Son();

        f.dost(1);
        s.dost(4);
        s.dost("dispatchTest");
        //s.dost("test",5);
    }
}

class Father{
    public void dost (int i){
        System.out.println("Welcome Father！int="+i);
    }
    public void dost(String s){
        System.out.println("Welcome Father！ String="+s);
    }
}

class Son extends Father{
    public void dost (int i){
        System.out.println("Welcome Son！int="+i);
    }
    public void dost(int i ,String s){
        System.out.println("Welcome Son！ int="+i+"String="+s);
    }
}

 