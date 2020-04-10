package Thread;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/4/10
 *
 * 线程调用
 */
public class WrongResult {

    volatile static int i;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++){
                    i ++;
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
        
    }

}
