package Atomic;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程池
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/9/21 11:25
 */
public class TestThreadPool {

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(1); //线程容量：阻塞队列数+最大线程数
        //假如默认线程名不满足你业务需要,可以自己创建线程工厂,然后定义线程名
        ThreadFactory threadFactory = new ThreadFactory() {
            //AtomicLong 提供了一种线程安全的自增或自减算法对一个整数进行计算
            private AtomicLong al=new AtomicLong(1);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "db-thread-" + al.getAndIncrement());
            }
        };
        // 1.构建一个线程池
        ThreadPoolExecutor tp=new ThreadPoolExecutor(
                2,//corePoolSize 核心线程数(当使用池对象执行任务时,池中线程没有达到corePoolSize设置定值时,每来一个新的任务都会创建一个新的线程)
                3,//maximumPoolSize 最大线程(当核心线程都在忙,队列也满,再来新的任务则创建新线程)
                60,//keepAliveTime 最大空闲时间
                TimeUnit.SECONDS, //unit 时间单位
                workQueue,//workQueue阻塞式队列
                threadFactory,//创建线程的工厂
                new ThreadPoolExecutor.CallerRunsPolicy());//任务拒绝执行策略,这里选择了CallerRunsPolicy对象(表示最后由调用者线程执行)
        //2.启动池中线程执行任务

        tp.execute(new Runnable() {
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+" execute task 01");
                try{Thread.sleep(5000);}catch (Exception e) {}
            }
        });
        tp.execute(new Runnable() {
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+" execute task 02");
                try{Thread.sleep(5000);}catch (Exception e) {}
            }
        });
        tp.execute(new Runnable() {
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+" execute task 03");
                try{Thread.sleep(5000);}catch (Exception e) {}
            }
        });
        tp.execute(new Runnable() {
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+" execute task 04");
                try{Thread.sleep(5000);}catch (Exception e) {}
            }
        });
        tp.execute(new Runnable() {
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+" execute task 05");
                try{Thread.sleep(5000);}catch (Exception e) {}
            }
        });

    }
}
