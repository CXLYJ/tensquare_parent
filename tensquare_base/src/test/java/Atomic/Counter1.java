package Atomic;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/9/18 11:09
 */
public class Counter1 {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void inc(){
        try{
            Thread.sleep(1); //延迟1毫秒

        }catch (InterruptedException e){ //catch住中断异常，防止程序中断
            e.printStackTrace();

        }
        count.getAndIncrement();//count值自加1
    }


    public static void main(String[] args) throws InterruptedException {


        final CountDownLatch latch = new CountDownLatch(100);

        for(int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter1.inc();
                    latch.countDown();
                }
            }).start();
        }
        latch.await();

        System.out.println("运行结果："+ Counter1.count);


    }

}
