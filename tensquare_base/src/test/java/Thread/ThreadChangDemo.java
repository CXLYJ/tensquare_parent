package Thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/13
 */
public class ThreadChangDemo {

    public static void main(String[] args) {
        dynamicModifyExecutor();
    }

    private static ThreadPoolExecutor buildThreadPoolExecutor(){
        return new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10),
                new NameThreadFactory());
    }

    private static void dynamicModifyExecutor() {
    }

}
