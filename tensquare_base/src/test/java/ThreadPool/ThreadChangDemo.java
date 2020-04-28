package ThreadPool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/13
 *
 * 自定义线程池
 */
public class ThreadChangDemo {

    public static void main(String[] args) throws InterruptedException {
        dynamicModifyExecutor();
    }

    private static ThreadPoolExecutor buildThreadPoolExecutor(){
        return new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10),
                new NameThreadFactory("iclyj技术"));
    }

    private static void dynamicModifyExecutor() throws InterruptedException {
        ThreadPoolExecutor executor = buildThreadPoolExecutor();
        for (int i = 0; i < 15; i++){
            executor.submit(() -> {
               threadPoolStatus(executor, "创建任务");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolStatus(executor, "改变之前");
        executor.setCorePoolSize(10);
        executor.setMaximumPoolSize(10);
        threadPoolStatus(executor, "改变之后");
        Thread.currentThread().join();
    }

    private static void threadPoolStatus(ThreadPoolExecutor executor, String name) {
        LinkedBlockingDeque queue = (LinkedBlockingDeque) executor.getQueue();
        System.out.println(Thread.currentThread().getName() + "_" + name + "-:" +
                "核心线程数：" + executor.getCorePoolSize() +
                "活跃线程数：" + executor.getActiveCount() +
                "最大线程数：" + executor.getMaximumPoolSize() +
                "线程池活跃度：" +
                            divide(executor.getActiveCount(), executor.getMaximumPoolSize()) +
                "任务完成数：" + executor.getCompletedTaskCount() +
                "队列大小：" + (queue.size() + queue.remainingCapacity()) +
                "当前排队线程数：" + queue.size() +
                "队列剩余大小：" + queue.remainingCapacity() +
                "队列实用度：" + divide(queue.size(), queue.size() + queue.remainingCapacity())
                );
    }

    private static String divide(int num1, int num2){
        return String.format("%1.2f%%",
                Double.parseDouble(num1 + "") / Double.parseDouble(num2 + "") * 100);
    }

}
