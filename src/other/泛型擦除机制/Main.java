package other.泛型擦除机制;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 泛型擦除机制
 * <p>
 * 泛型，是编译期的约束，当运行期就会失去作用
 */
public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        System.out.println(list.size());
        //搞它
        Class c = list.getClass();
        Method method = c.getMethod("add", Object.class);
        method.invoke(list, "TOM");
        System.out.println(list.size());
      
    }

}
