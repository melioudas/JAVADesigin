package chain.main;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链
 * <p>
 * 和原始设计不同的是，每个filter不用组合下一级filter，由FilterChain进行组合
 * <p>
 * 实例：过滤字符串，对字符传中的部分进行替换
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String str = "<scr1ipt> baidu.com,):,嘿嘿嘿一giao我哩giao!    </scrip1t>";
        Msg msg = Msg.class.newInstance();
        msg.setStr(str);
        //1.两个链可以拼接 2.实现可以在某个链中停止
        FilterChain filterChain1 = new FilterChain();
        FilterChain filterChain2 = new FilterChain();
        Filter jsfilter = new JSFilter();
        Filter hostfilter = new HOSTFilter();
        filterChain1.addFilter(jsfilter);
        filterChain2.addFilter(hostfilter);
        filterChain1.addFilter(filterChain2);

        filterChain1.doFilter(msg);
        System.out.println(msg.getStr());
    }
}

//过滤器接口
interface Filter {
    boolean doFilter(Msg str);
}

class Msg {
    String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

//js符号过滤
class JSFilter implements Filter {

    @Override
    public boolean doFilter(Msg str) {
        if (str.getStr().contains("script")) {
            return false;
        }

        String r = str.getStr().replaceAll("<", "[");
        r = r.replaceAll(">", "]");
        str.setStr(r);
        return true;
    }
}

//HOST符号过滤
class HOSTFilter implements Filter {

    @Override
    public boolean doFilter(Msg str) {
        String r = str.getStr().replaceAll("baidu.com", "http://www.baidu.com");
        str.setStr(r);
        return true;
    }
}

//链化思想
class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public boolean doFilter(Msg msg) {
        for (Filter filter : filters) {
            if (!filter.doFilter(msg)) return false;
        }
        return true;
    }

}