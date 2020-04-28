package ThreadPool;

import lombok.Data;

import java.util.Date;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/13
 */
public class NameThreadFactory implements ThreadFactory {

    /**
     *
     * 构建自己的线程工厂类，这样你就可以方便的设置线程名字啦。
     * 创建线程或线程池时请指定有意义的线程名称，方便出错时回溯。
     * 创建线程池的时候请使用带ThreadFactory的构造函数，
     * 并且提供自定义ThreadFactory实现或者使用第三方实现。
     */

    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    private String name;

    public NameThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-" +mThreadNum.getAndIncrement() + "-" + new Date());
//        System.out.println(t.getName() + "has been created");
        return t;
    }
}
