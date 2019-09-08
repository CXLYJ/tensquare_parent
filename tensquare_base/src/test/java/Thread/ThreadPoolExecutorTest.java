package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/9/8
 */
public class ThreadPoolExecutorTest {

    /**
     * public ThreadPoolExecutor(int corePoolSize,
     *                               int maximumPoolSize,
     *                               long keepAliveTime,
     *                               TimeUnit unit,
     *                               BlockingQueue<Runnable> workQueue,
     *                               ThreadFactory threadFactory,
     *                               RejectedExecutionHandler handler)
     *
     *
     *
     * 这7个参数的含义如下：
     *
     * corePoolSize 线程池核心线程数。即线程池中保留的线程个数，即使这些线程是空闲的，也不会被销毁，除非通过ThreadPoolExecutor的allowCoreThreadTimeOut(true)方法开启了核心线程的超时策略；
     *
     * maximumPoolSize 线程池中允许的最大线程个数；
     *
     * keepAliveTime 用于设置那些超出核心线程数量的线程的最大等待时间，超过这个时间还没有新任务的话，超出的线程将被销毁；
     *
     * unit 超时时间单位；
     *
     * workQueue 线程队列。用于保存通过execute方法提交的，等待被执行的任务；
     *
     * threadFactory 线程创建工程，即指定怎样创建线程；
     *
     * handler 拒绝策略。即指定当线程提交的数量超出了maximumPoolSize后，该使用什么策略处理超出的线程。
     *
     * 在通过这个构造方法创建线程池的时候，这几个参数必须满足以下条件，否则将抛出IllegalArgumentException异常：
     *
     * corePoolSize不能小于0；
     *
     * keepAliveTime不能小于0；
     *
     * maximumPoolSize 不能小于等于0；
     *
     * maximumPoolSize不能小于corePoolSize；
     *
     * 此外，workQueue、threadFactory和handler不能为null，否则将抛出空指针异常。
     *
     * 下面举些例子来深入理解这几个参数的含义。
     *
     * 使用上面的构造方法创建一个线程池：
     * @param args
     */

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, 2, 10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), (ThreadFactory) Thread::new,
                new ThreadPoolExecutor.AbortPolicy());
        System.out.println("线程池创建完毕");

        int activeCount = -1;
        int queueSize = -1;
        while (true) {
            if (activeCount != threadPoolExecutor.getActiveCount()
                    || queueSize != threadPoolExecutor.getQueue().size()) {
                System.out.println("活跃线程个数 " + threadPoolExecutor.getActiveCount());
                System.out.println("核心线程个数 " + threadPoolExecutor.getCorePoolSize());
                System.out.println("队列线程个数 " + threadPoolExecutor.getQueue().size());
                System.out.println("最大线程数 " + threadPoolExecutor.getMaximumPoolSize());
                System.out.println("------------------------------------");
                activeCount = threadPoolExecutor.getActiveCount();
                queueSize = threadPoolExecutor.getQueue().size();
            }
        }
    }

}
