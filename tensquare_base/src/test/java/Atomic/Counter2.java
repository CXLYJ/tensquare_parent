package Atomic;

import java.util.concurrent.CountDownLatch;

/**
 * TODO
 *
 * @author ：lyj
 * @email: ：liyj@nysoftland.com.cn
 * @date ：2020/9/18 13:59
 */
public class Counter2 {

    private volatile static int count = 0;
    public static void inc(){
        try {
            Thread.sleep(1);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        count ++;
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(100);
        for (int i= 0; i < 100; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter2.inc();
                    latch.countDown();
                }
            }).start();
        }
        latch.await();
        System.out.println("运行结果："+Counter2.count);
    }

}
